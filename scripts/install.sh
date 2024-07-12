#!/bin/sh

if [ ! ${experiment_root} ]
then
    echo "experiment_root is unset in the shell"
    echo "please set experiment_root to point to your experiment directory"
    echo "see README for more information:"
    exit 2
fi

if test $# -ne 1
	then \
		echo Usage:
		echo install.sh comp_dir 
		echo comp_dir: orig/fixed
		exit 0
fi

subject_dir=${experiment_root}/log4j3
echo removing old files
rm -f -r ${subject_dir}/source/*
rm -f ${subject_dir}/outputs/*

if [ $1 = "orig" -o $1 = "fixed" ]
then
     echo copying files for $1 version
     mkdir -p ${subject_dir}/source/$1
     cp -r ${subject_dir}/versions.alt/$1/* ${subject_dir}/source/$1
else
    echo orig/fixed is the only option currently available
    exit 0
fi
cd ${subject_dir}/source

echo compiling application
echo "java home"
echo $JAVA_HOME
cp=`find ${subject_dir}/lib -name "*.jar"|xargs echo|sed 's/ /:/g'`
find . -name "*.java" | xargs javac -deprecation -cp $cp > /dev/null
