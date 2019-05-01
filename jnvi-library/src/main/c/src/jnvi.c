//----------------------
// Java Native Vectorisation Interface (JNVI)
// JNVI x86 library implementation
//
// Supports: SSE, SSE2, SSSE3, SSE4.1, SSE4.2, AVX and AVX2
//
// Author: Jaspreet Singh Dhanjan
// The University of Huddersfield
// ----------------------

#include <stdio.h>
#include <immintrin.h>

#include "../include/jnvi.h"
//#include "../include/avx_mathfun.h"

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

void jnvi_add_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] + src2[i];
	}
}

void jnvi_add_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] + src2[i];
	}
}

void jnvi_add_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] + src2[i];
	}
}

void jnvi_sub_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] - src2[i];
	}
}

void jnvi_sub_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] - src2[i];
	}
}

void jnvi_sub_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] - src2[i];
	}
}

void jnvi_mul_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] * src2[i];
	}
}

void jnvi_mul_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] * src2[i];
	}
}

void jnvi_mul_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] * src2[i];
	}
}

void jnvi_div_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] / src2[i];
	}
}

void jnvi_div_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] / src2[i];
	}
}

void jnvi_div_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] / src2[i];
	}
}

void jnvi_dot_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		*dest += src1[i] * src2[i];
	}
}

void jnvi_dot_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		*dest += (src1[i] * src2[i]);
	}
}

void jnvi_dot_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		*dest += src1[i] * src2[i];
	}
}

void jnvi_sum_f(const fvec *src, fvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		*dest += src[i];
	}
}

void jnvi_sum_d(const dvec *src, dvec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		*dest += src[i];
	}
}

void jnvi_sum_i(const ivec *src, ivec *dest, const int n) {
	#pragma omp simd
	for (int i = 0; i < n; i++) {
		*dest += src[i];
	}
}

void jnvi_sqrt_d(const dvec *src, dvec *dest, const int n) {
	__m256d vec = _mm256_load_pd(src);
    __m256d res = _mm256_sqrt_pd(vec);
    _mm256_store_pd(dest, res);
}

void jnvi_sqrt_f(const fvec *src, fvec *dest, const int n) {
    __m256 vec = _mm256_load_ps(src);
    __m256 res = _mm256_sqrt_ps(vec);
    _mm256_store_ps(dest, res);
}

void jnvi_rsqrt_f(const fvec *src, fvec *dest, const int n) {
    __m256 vec = _mm256_load_ps(src);
    __m256 res = _mm256_rsqrt_ps(vec);
    _mm256_store_ps(dest, res);
}