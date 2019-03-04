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

int is_supported() {
    return (SSE_SUPPORTED | SSE2_SUPPORTED | SSE3_SUPPORTED | SSSE3_SUPPORTED | SSE41_SUPPORTED | SSE42_SUPPORTED | AVX_SUPPORTED | AVX2_SUPPORTED);
}

void mul_store_floats(float *a, float *b, float *c) {
    // TODO: Check for each vector extension and pick most suitable op.

//    __m128 vector1 = _mm_load_ps(a);
//    __m128 vector2 = _mm_load_ps(b);
//
//    __m128 result = vector1 * vector2;
//
//    _mm_store_ps(c, result);

    __m256 vector1 = _mm256_load_ps(a);
    __m256 vector2 = _mm256_load_ps(b);

    __m256 result = vector1 * vector2;

    _mm256_store_ps(c, result);


//      __m256 evens = _mm256_set_ps(2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0);
//      __m256 odds = _mm256_set_ps(1.0, 3.0, 5.0, 7.0, 9.0, 11.0, 13.0, 15.0);
//
//      __m256 result = _mm256_sub_ps(evens, odds);
//
//      float* f = (float*)&result;
//      printf("%f %f %f %f %f %f %f %f\n", f[0], f[1], f[2], f[3], f[4], f[5], f[6], f[7]);
}