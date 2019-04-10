#!/bin/sh

set -e

echo "Building Java Native Vectorisation Interface (JNVI) library..."

export JAVA_HOME="jdk1.8.0_60/Home"

OSX_LIB=jnvi-lib.jnilib

API=src/main/java/uk/ac/hud/jnvi/api/*
LIBDIR=target/
NATIVE_SOURCES=src/main/c/src/*
NATIVE_HEADERS=src/main/c/include

# ----- STEP 1: Generate header files in the c/include directory. -----

javac -h $NATIVE_HEADERS $API
rm -rf ${API}.class

# ----- STEP 2: Compile native library and move to lib. -----

# The -mavx2 argument will allow us to enable AVX. TODO We need to add all the args in.
# Use sysctl -a | grep machdep.cpu.features to get what is supported. Add this to compile-time args.

#Jaspreets-MBP:~ jaspreetdhanjan$ sysctl -a | grep machdep.cpu.features
#machdep.cpu.features: FPU VME DE PSE TSC MSR PAE MCE CX8 APIC SEP MTRR PGE MCA CMOV PAT PSE36 CLFSH DS ACPI MMX FXSR SSE SSE2 SS HTT TM PBE SSE3 PCLMULQDQ DTES64 MONDSCPL VMX EST TM2 SSSE3 FMA CX16 TPR PDCM SSE4.1 SSE4.2 x2APIC MOVBE POPCNT AES PCID XSAVE OSXSAVE SEGLIM64 TSCTMR AVX1.0 RDRAND F16C

# macOS
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -mavx2 -o $OSX_LIB -shared $NATIVE_SOURCES
mv $OSX_LIB $LIBDIR