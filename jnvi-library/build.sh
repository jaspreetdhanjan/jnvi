#!/bin/sh

set -e

echo "Building Java Native Vectorisation Interface (JNVI) library..."

export JAVA_HOME="jdk1.8.0_60/Home"

API=src/main/java/uk/ac/hud/jnvi/api/*
LIBDIR=target/
LIBNAME=jnvilib.jnilib
NATIVE_SOURCES=src/main/c/src/*
NATIVE_HEADERS=src/main/c/include

# ----- STEP 1: Generate header files in the c/include directory. -----

javac -h $NATIVE_HEADERS $API
rm -rf ${API}.class

# ----- STEP 2: Compile native library and move to lib. -----

gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -o $LIBNAME -shared $NATIVE_SOURCES
mv $LIBNAME $LIBDIR