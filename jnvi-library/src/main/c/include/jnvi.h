//----------------------
// Java Native Vectorisation Interface (JNVI)
// JNVI x86 library implementation
//
// Supports: SSE, SSE2, SSSE3, SSE4.1, SSE4.2, AVX and AVX2
//
// Author: Jaspreet Singh Dhanjan
// The University of Huddersfield
// ----------------------

#ifndef _JNVI_H
#define _JNVI_H

#define JNVI_API_VERSION 1

#define JNVI_TYPE_DOUBLE 1
#define JNVI_TYPE_FLOAT 2
#define JNVI_TYPE_INT 3

typedef double dvec;
typedef float fvec;
typedef int ivec;

unsigned int jnvi_is_supported();

// Operations

void jnvi_add_d(const dvec*, const dvec*, dvec*, const int);
void jnvi_add_f(const fvec*, const fvec*, fvec*, const int);
void jnvi_add_i(const ivec*, const ivec*, ivec*, const int);

void jnvi_sub_d(const dvec*, const dvec*, dvec*, const int);
void jnvi_sub_f(const fvec*, const fvec*, fvec*, const int);
void jnvi_sub_i(const ivec*, const ivec*, ivec*, const int);

void jnvi_mul_d(const dvec*, const dvec*, dvec*, const int);
void jnvi_mul_f(const fvec*, const fvec*, fvec*, const int);
void jnvi_mul_i(const ivec*, const ivec*, ivec*, const int);

void jnvi_div_d(const dvec*, const dvec*, dvec*, const int);
void jnvi_div_f(const fvec*, const fvec*, fvec*, const int);
void jnvi_div_i(const ivec*, const ivec*, ivec*, const int);

void jnvi_dot_d(const dvec*, const dvec*, dvec*, const int);
void jnvi_dot_f(const fvec*, const fvec*, fvec*, const int);
void jnvi_dot_i(const ivec*, const ivec*, ivec*, const int);

void jnvi_sum_d(const dvec*, dvec*, const int);
void jnvi_sum_f(const fvec*, fvec*, const int);
void jnvi_sum_i(const ivec*, ivec*, const int);

void jnvi_sqrt_d(const dvec*, dvec*, const int);
void jnvi_sqrt_f(const fvec*, fvec*, const int);

void jnvi_rsqrt_f(const fvec*, fvec*, const int);

#endif