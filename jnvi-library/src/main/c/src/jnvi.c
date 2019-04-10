//----------------------
// Java Native Vectorisation Interface (JNVI)
// JNVI x86 library implementation
//
// Supports: SSE, SSE2, SSSE3, SSE4.1, SSE4.2, AVX and AVX2
//
// Author: Jaspreet Singh Dhanjan
// The University of Huddersfield
// ----------------------

#include "../include/jnvi.h"

#include <immintrin.h>
#include <stdio.h>

// Luckily, GCC can tell us what is supported!
// https://gcc.gnu.org/onlinedocs/gcc-4.9.2/gcc/X86-Built-in-Functions.html
#define SSE_SUPPORTED __builtin_cpu_supports("sse")
#define SSE2_SUPPORTED __builtin_cpu_supports("sse2")
#define SSE3_SUPPORTED __builtin_cpu_supports("sse3")
#define SSSE3_SUPPORTED __builtin_cpu_supports("ssse3")
#define SSE41_SUPPORTED __builtin_cpu_supports("sse4.1")
#define SSE42_SUPPORTED __builtin_cpu_supports("sse4.2")
#define AVX_SUPPORTED __builtin_cpu_supports("avx")
#define AVX2_SUPPORTED __builtin_cpu_supports("avx2")

unsigned int jnvi_is_supported() {
    unsigned int supported = 0;

    supported = (supported | AVX2_SUPPORTED) << 1;
    supported = (supported | AVX_SUPPORTED) << 1;
    supported = (supported | SSE42_SUPPORTED) << 1;
    supported = (supported | SSE41_SUPPORTED) << 1;
    supported = (supported | SSSE3_SUPPORTED) << 1;
    supported = (supported | SSE3_SUPPORTED) << 1;
    supported = (supported | SSE2_SUPPORTED) << 1;
    supported = (supported | SSE_SUPPORTED);

    return supported;
}

unsigned int jnvi_get_largest_stride(int sizeOfVal) {
    const unsigned int supported = jnvi_is_supported();

    for (unsigned int i = 7; i > 0; i--) {
        unsigned int pos = 1 << i;
        if ((supported & pos) == 1) {
            if (i == 7) return 256 / sizeOfVal;
            if (i == 6) return 256 / sizeOfVal;
            if (i == 5) return 256 / sizeOfVal;
            if (i == 4) return 256 / sizeOfVal;
            if (i == 3) return 256 / sizeOfVal;
            if (i == 2) return 256 / sizeOfVal;
            if (i == 1) return 128 / sizeOfVal;
            if (i == 0) return 128 / sizeOfVal;
        }
    }
    return 4;
}

void jnvi_add_f(const fvec *src1, const fvec *src2, fvec *dest) {
    __m256 vec_1 = _mm256_load_ps(src1);
    __m256 vec_2 = _mm256_load_ps(src2);
    __m256 res = _mm256_add_ps(vec_1, vec_2);

    _mm256_store_ps(dest, res);
}

void jnvi_add_d(const dvec *src1, const dvec *src2, dvec *dest) {
}

void jnvi_add_i(const ivec *src1, const ivec *src2, ivec *dest) {
}

void jnvi_sub_f(const fvec *src1, const fvec *src2, fvec *dest) {
    __m256 vec_1 = _mm256_load_ps(src1);
    __m256 vec_2 = _mm256_load_ps(src2);
    __m256 res = _mm256_sub_ps(vec_1, vec_2);

    _mm256_store_ps(dest, res);
}

void jnvi_sub_d(const dvec *src1, const dvec *src2, dvec *dest) {
}

void jnvi_sub_i(const ivec *src1, const ivec *src2, ivec *dest) {
}

void jnvi_mul_f(const fvec *src1, const fvec *src2, fvec *dest) {
    __m256 vec_1 = _mm256_load_ps(src1);
    __m256 vec_2 = _mm256_load_ps(src2);
    __m256 res = _mm256_mul_ps(vec_2, vec_1);

    _mm256_store_ps(dest, res);


    // TODO: Check for each vector extension and pick most suitable op.

//    __m128 vector1 = _mm_load_ps(a);
//    __m128 vector2 = _mm_load_ps(b);
//
//    __m128 result = vector1 * vector2;
//
//    _mm_store_ps(c, result);



//    printf("%f %f %f %f\n", a[0], a[1], a[2], a[3]);
//    printf("%f %f %f %f\n", b[0], b[1], b[2], b[3]);
//    printf("%f %f %f %f\n", c[0], c[1], c[2], c[3]);


      // This is wrong.
      // In our examples we are only using DirectFloats of length 8, which match this reg size.
      // we need to make a for loop, that iterates through the pointer data and assembles the register data.
      // Get the best register to do this.

//      __m256 evens = _mm256_set_ps(2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0);
//      __m256 odds = _mm256_set_ps(1.0, 3.0, 5.0, 7.0, 9.0, 11.0, 13.0, 15.0);
//
//      __m256 result = _mm256_sub_ps(evens, odds);
//
//      fvec* f = (fvec*)&result;
//      printf("%f %f %f %f %f %f %f %f\n", f[0], f[1], f[2], f[3], f[4], f[5], f[6], f[7]);
}

void jnvi_mul_d(const dvec *src1, const dvec *src2, dvec *dest) {
}

void jnvi_mul_i(const ivec *src1, const ivec *src2, ivec *dest) {
}

void jnvi_div_f(const fvec *src1, const fvec *src2, fvec *dest) {
    __m256 vec_1 = _mm256_load_ps(src1);
    __m256 vec_2 = _mm256_load_ps(src2);
    __m256 res = _mm256_div_ps(vec_1, vec_2);

    _mm256_store_ps(dest, res);
}

void jnvi_div_d(const dvec *src1, const dvec *src2, dvec *dest) {
}

void jnvi_div_i(const ivec *src1, const ivec *src2, ivec *dest) {
}