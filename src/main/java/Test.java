/**
 * @ClassName Test  //类名称
 * @Description: 类描述
 * @Author: bupt    //作者
 * @CreateDate: 2024/6/12 4:49	//创建时间
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/6/12 4:49	//更新时间
 * @UpdateRemark: 更新的信息
 * @Version: 1.0    //版本号
 */

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.classLoader.JarFileModule;
import com.ibm.wala.ipa.callgraph.*;
import com.ibm.wala.ipa.callgraph.impl.DefaultEntrypoint;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.callgraph.propagation.*;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.ipa.cha.IClassHierarchy;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.util.config.AnalysisScopeReader;
import com.ibm.wala.util.io.FileProvider;


import java.io.*;
import java.util.*;
import java.util.jar.JarFile;

public class Test {
    public static final String DESC_MAIN = "([Ljava/lang/String;)V";

    public static void main(String[] args) throws Throwable {
        PrintStream ps = System.out;
        String mainClassName ;

        String classpath;
        if (args==null||args.length==0){
            classpath = ".\\source";
            mainClassName = "org.apache.log4j.TestThrowableStrRep";
        }else {
            classpath=args[0];
            mainClassName=args[1];
        }

        AnalysisScope scope =AnalysisScopeReader.makeJavaBinaryAnalysisScope(classpath,(new FileProvider()).getFile("EclipseDefaultExclusions.txt"/*"/data/mywork/llm/EclipseDefaultExclusions.txt"*/));

        List<JarFile> dependencyJars = new ArrayList<>();
        dependencyJars.add(new JarFile(".\\lib\\javaee-api-5.jar"));
        dependencyJars.add(new JarFile(".\\lib\\jmxtools-1.2.jar"));
        for (JarFile jarFile : dependencyJars) {
            scope.addToScope(ClassLoaderReference.Primordial, new JarFileModule(jarFile));
        }

        ClassHierarchy cha = ClassHierarchyFactory.make(scope);
        System.out.println(cha.getNumberOfClasses() + " classes");
        String mainSignature = ".main"+DESC_MAIN;
        String mainMethodSig =
                mainClassName + mainSignature;
        Iterable<Entrypoint> entrypoints = findEntryPoints(cha, mainClassName,false);

        AnalysisOptions options = new AnalysisOptions(scope,entrypoints);


        AnalysisCache cache = new AnalysisCacheImpl();
        SSAPropagationCallGraphBuilder builder = Util.makeZeroOneContainerCFABuilder(options, cache, cha, scope);
//        IPASSAPropagationCallGraphBuilder builder = IPAUtil.makeIPAZeroCFABuilder(Language.JAVA, options, new AnalysisCacheImpl(), cha, scope);


        long start_time = System.currentTimeMillis();
        CallGraph cg  = builder.makeCallGraph(options, null);


        PointerAnalysis<InstanceKey> pta = builder.getPointerAnalysis();
        System.out.println("Call Graph Construction Time: "+(System.currentTimeMillis()-start_time));




    }

//    public static boolean dfs(Set<String> markedFunctions,CGNode node,CallGraph cg){
//        if (node==null){
//            return false;
//        }
//        String sig=node.getMethod().getSignature();
//        boolean res=false;
//        res|=markedFunctions.contains(sig);
//        for (Iterator<? extends CGNode> it = cg.getSuccNodes(node); it.hasNext();) {
//            CGNode callee = it.next();
//            res|=dfs(markedFunctions,callee,cg);
//        }
//        if (res){
//            markedFunctions.add(sig);
//        }
//        return res;
//    }


//    private static Iterable<Entrypoint> makePublicEntrypoints(IClassHierarchy cha, String entryClass) {
//        Collection<Entrypoint> result = new ArrayList<>();
//        IClass klass = cha.lookupClass(TypeReference.findOrCreate(ClassLoaderReference.Application,
//                StringStuff.deployment2CanonicalTypeString(entryClass)));
//        for (IMethod m : klass.getDeclaredMethods()) {
//            if (m.isPublic()) {
//                result.add(new DefaultEntrypoint(m, cha));
//            }
//        }
//        return result;
//    }
    public static Iterable<Entrypoint> findEntryPoints(IClassHierarchy classHierarchy, String mainClassName, boolean includeAll) {
        Set<Entrypoint> result = new HashSet<>();//HashSetFactory.make();
        Iterator<IClass> classIterator = classHierarchy.iterator();
        String className=mainClassName.replace(".", "/");
        while (classIterator.hasNext()) {
            IClass klass = classIterator.next();
            if (!AnalysisUtils.isJDKClass(klass)) {
                for (IMethod method : klass.getDeclaredMethods()) {
                    try {
                        if(method.isStatic()&&method.isPublic()
                                &&method.getName().toString().equals("main")
                                &&method.getDescriptor().toString().equals(DESC_MAIN))
                        {
                            //Test: accept only one main entryPoint
                            System.out.println(method);
                            if(includeAll
                                    ||klass.getName().toString().contains(/*mainClassName*/className)) {
                                result.add(new DefaultEntrypoint(method, classHierarchy));
                                System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                            }
                        }
                        else if(method.isPublic()&&!method.isStatic()
                                &&method.getName().toString().equals("run")
                                &&method.getDescriptor().toString().equals("()V"))
                        {
                            if (AnalysisUtils.implementsRunnableInterface(klass) || AnalysisUtils.extendsThreadClass(klass))
                                result.add(new DefaultEntrypoint(method, classHierarchy));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return new Iterable<Entrypoint>() {
            public Iterator<Entrypoint> iterator() {
                return result.iterator();
            }
        };

}



}