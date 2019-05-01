#!/usr/bin/env bash

gcc -msse -msse2 -msse3 -mssse3 -msse4.1 -msse4.2 -mavx -mavx2 -mfma -O3 -S src/main/c/src/jnvi.c