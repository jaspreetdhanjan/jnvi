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

#include "../include/jnvi.h"
#include "../include/avx_mathfun.h"

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
//    __m256 vec_1 = _mm256_load_ps(src1);
//    __m256 vec_2 = _mm256_load_ps(src2);
//    __m256 res = _mm256_add_ps(vec_1, vec_2);
//
//    _mm256_store_ps(dest, res);

	#pragma omp parallel for
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] + src2[i];
	}

/*
    int block = 4;

    __m128 vec_1, vec_2, result;
    for (int k = 0; k < n; k += block) {
        vec_1 = _mm_load_ps(src1 + k);
        vec_2 = _mm_load_ps(src2 + k);
        result = _mm_add_ps(vec_1, vec_2);

        _mm_store_ps(dest + k, result);
    }*/
}

void jnvi_add_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp parallel for
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] + src2[i];
	}
}

void jnvi_add_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp parallel for
	for (int i = 0; i < n; i++) {
		dest[i] = src1[i] + src2[i];
	}
}

void jnvi_sub_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] - src2[i];
	}


//	__m256 vec_1 = _mm256_load_ps(src1);
//	__m256 vec_2 = _mm256_load_ps(src2);
//	__m256 res = _mm256_sub_ps(vec_1, vec_2);
//	_mm256_store_ps(dest, res);

/*
    int block = 8;

    __m256 vec_1, vec_2, result;
    for (int k = 0; k < n; k += block) {
        vec_1 = _mm256_load_ps(src1 + k);
        vec_2 = _mm256_load_ps(src2 + k);
        result = _mm256_sub_ps(vec_1, vec_2);

        _mm256_store_ps(dest + k, result);
    }*/
}

void jnvi_sub_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] - src2[i];
	}
}

void jnvi_sub_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] - src2[i];
	}
}

void jnvi_mul_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] * src2[i];
	}

//	__m256 vec_1 = _mm256_load_ps(src1);
//	__m256 vec_2 = _mm256_load_ps(src2);
//	__m256 res = _mm256_mul_ps(vec_1, vec_2);
//	_mm256_store_ps(dest, res);

/*
    int block = 8;

    __m256 vec_1, vec_2, result;
    for (int k = 0; k < n; k += block) {
        vec_1 = _mm256_load_ps(src1 + k);
        vec_2 = _mm256_load_ps(src2 + k);
        result = _mm256_mul_ps(vec_1, vec_2);

        _mm256_store_ps(dest + k, result);
    }*/
}

void jnvi_mul_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] * src2[i];
	}
}

void jnvi_mul_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] * src2[i];
	}
}

void jnvi_div_f(const fvec *src1, const fvec *src2, fvec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] / src2[i];
	}

//	__m256 vec_1 = _mm256_load_ps(src1);
//	__m256 vec_2 = _mm256_load_ps(src2);
//	__m256 res = _mm256_div_ps(vec_1, vec_2);
//	_mm256_store_ps(dest, res);

/*
    int block = 8;

    __m256 vec_1, vec_2, result;
    for (int k = 0; k < n; k += block) {
        vec_1 = _mm256_load_ps(src1 + k);
        vec_2 = _mm256_load_ps(src2 + k);
        result = _mm256_div_ps(vec_1, vec_2);

        _mm256_store_ps(dest + k, result);
    }*/
}

void jnvi_div_d(const dvec *src1, const dvec *src2, dvec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] / src2[i];
	}
}

void jnvi_div_i(const ivec *src1, const ivec *src2, ivec *dest, const int n) {
	#pragma omp parallel for
	for(int i = 0; i < n; i++) {
		dest[i] = src1[i] / src2[i];
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

void jnvi_sin_f(const fvec *src, fvec *dest, const int n) {
    __m256 vec = _mm256_load_ps(src);
    __m256 res = sin256_ps(vec);
    _mm256_store_ps(dest, res);
}

void jnvi_cos_f(const fvec *src, fvec *dest, const int n) {
    __m256 vec = _mm256_load_ps(src);
    __m256 res = cos256_ps(vec);
    _mm256_store_ps(dest, res);
}

//void jnvi_sincos_f(const fvec *src, fvec *dest, const int n) {
//    __m256 vec = _mm256_load_ps(src);
//    __m256 res = sincos256_ps(vec);
//    _mm256_store_ps(dest, res);
//}

void jnvi_exp_f(const fvec *src, fvec *dest, const int n) {
    __m256 vec = _mm256_load_ps(src);
    __m256 res = exp256_ps(vec);
    _mm256_store_ps(dest, res);
}

void jnvi_log_f(const fvec *src, fvec *dest, const int n) {
    __m256 vec = _mm256_load_ps(src);
    __m256 res = log256_ps(vec);
    _mm256_store_ps(dest, res);
}