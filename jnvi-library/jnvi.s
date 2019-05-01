	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 10, 14
	.globl	_jnvi_is_supported      ## -- Begin function jnvi_is_supported
	.p2align	4, 0x90
_jnvi_is_supported:                     ## @jnvi_is_supported
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	___cpu_model@GOTPCREL(%rip), %rax
	movl	12(%rax), %eax
	shrl	$3, %eax
	movzbl	%al, %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_add_f             ## -- Begin function jnvi_add_f
	.p2align	4, 0x90
_jnvi_add_f:                            ## @jnvi_add_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB1_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$31, %ecx
	ja	LBB1_9
## %bb.2:
	xorl	%ecx, %ecx
	jmp	LBB1_3
LBB1_9:
	leaq	(%rdx,%r9,4), %rcx
	leaq	(%rdi,%r9,4), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r9,4), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB1_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB1_3
## %bb.11:
	movl	%r9d, %ecx
	andl	$-32, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB1_12:                                ## =>This Inner Loop Header: Depth=1
	vmovups	(%rdi,%rax,4), %ymm0
	vmovups	32(%rdi,%rax,4), %ymm1
	vmovups	64(%rdi,%rax,4), %ymm2
	vmovups	96(%rdi,%rax,4), %ymm3
	vaddps	(%rsi,%rax,4), %ymm0, %ymm0
	vaddps	32(%rsi,%rax,4), %ymm1, %ymm1
	vaddps	64(%rsi,%rax,4), %ymm2, %ymm2
	vaddps	96(%rsi,%rax,4), %ymm3, %ymm3
	vmovups	%ymm0, (%rdx,%rax,4)
	vmovups	%ymm1, 32(%rdx,%rax,4)
	vmovups	%ymm2, 64(%rdx,%rax,4)
	vmovups	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %rcx
	jne	LBB1_12
## %bb.13:
	cmpq	%r9, %rcx
	je	LBB1_14
LBB1_3:
	movq	%rcx, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB1_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB1_5:                                 ## =>This Inner Loop Header: Depth=1
	vmovss	(%rdi,%rcx,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vaddss	(%rsi,%rcx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rcx,4)
	incq	%rcx
	incq	%rax
	jne	LBB1_5
LBB1_6:
	cmpq	$3, %r8
	jb	LBB1_14
## %bb.7:
	subq	%rcx, %r9
	leaq	12(%rdx,%rcx,4), %rdx
	leaq	12(%rsi,%rcx,4), %rsi
	leaq	12(%rdi,%rcx,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB1_8:                                 ## =>This Inner Loop Header: Depth=1
	vmovss	-12(%rcx,%rdi,4), %xmm0 ## xmm0 = mem[0],zero,zero,zero
	vaddss	-12(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -12(%rdx,%rdi,4)
	vmovss	-8(%rcx,%rdi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vaddss	-8(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -8(%rdx,%rdi,4)
	vmovss	-4(%rcx,%rdi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vaddss	-4(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -4(%rdx,%rdi,4)
	vmovss	(%rcx,%rdi,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vaddss	(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rdi,4)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB1_8
LBB1_14:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_add_d             ## -- Begin function jnvi_add_d
	.p2align	4, 0x90
_jnvi_add_d:                            ## @jnvi_add_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB2_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$15, %ecx
	ja	LBB2_9
## %bb.2:
	xorl	%ecx, %ecx
	jmp	LBB2_3
LBB2_9:
	leaq	(%rdx,%r9,8), %rcx
	leaq	(%rdi,%r9,8), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r9,8), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB2_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB2_3
## %bb.11:
	movl	%r9d, %ecx
	andl	$-16, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB2_12:                                ## =>This Inner Loop Header: Depth=1
	vmovupd	(%rdi,%rax,8), %ymm0
	vmovupd	32(%rdi,%rax,8), %ymm1
	vmovupd	64(%rdi,%rax,8), %ymm2
	vmovupd	96(%rdi,%rax,8), %ymm3
	vaddpd	(%rsi,%rax,8), %ymm0, %ymm0
	vaddpd	32(%rsi,%rax,8), %ymm1, %ymm1
	vaddpd	64(%rsi,%rax,8), %ymm2, %ymm2
	vaddpd	96(%rsi,%rax,8), %ymm3, %ymm3
	vmovupd	%ymm0, (%rdx,%rax,8)
	vmovupd	%ymm1, 32(%rdx,%rax,8)
	vmovupd	%ymm2, 64(%rdx,%rax,8)
	vmovupd	%ymm3, 96(%rdx,%rax,8)
	addq	$16, %rax
	cmpq	%rax, %rcx
	jne	LBB2_12
## %bb.13:
	cmpq	%r9, %rcx
	je	LBB2_14
LBB2_3:
	movq	%rcx, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB2_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB2_5:                                 ## =>This Inner Loop Header: Depth=1
	vmovsd	(%rdi,%rcx,8), %xmm0    ## xmm0 = mem[0],zero
	vaddsd	(%rsi,%rcx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%rcx,8)
	incq	%rcx
	incq	%rax
	jne	LBB2_5
LBB2_6:
	cmpq	$3, %r8
	jb	LBB2_14
## %bb.7:
	subq	%rcx, %r9
	leaq	24(%rdx,%rcx,8), %rdx
	leaq	24(%rsi,%rcx,8), %rsi
	leaq	24(%rdi,%rcx,8), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB2_8:                                 ## =>This Inner Loop Header: Depth=1
	vmovsd	-24(%rcx,%rdi,8), %xmm0 ## xmm0 = mem[0],zero
	vaddsd	-24(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -24(%rdx,%rdi,8)
	vmovsd	-16(%rcx,%rdi,8), %xmm0 ## xmm0 = mem[0],zero
	vaddsd	-16(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -16(%rdx,%rdi,8)
	vmovsd	-8(%rcx,%rdi,8), %xmm0  ## xmm0 = mem[0],zero
	vaddsd	-8(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -8(%rdx,%rdi,8)
	vmovsd	(%rcx,%rdi,8), %xmm0    ## xmm0 = mem[0],zero
	vaddsd	(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%rdi,8)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB2_8
LBB2_14:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_add_i             ## -- Begin function jnvi_add_i
	.p2align	4, 0x90
_jnvi_add_i:                            ## @jnvi_add_i
	.cfi_startproc
## %bb.0:
	testl	%ecx, %ecx
	jle	LBB3_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$31, %ecx
	ja	LBB3_9
## %bb.2:
	xorl	%r10d, %r10d
	jmp	LBB3_3
LBB3_9:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	.cfi_offset %rbx, -24
	leaq	(%rdx,%r9,4), %rcx
	leaq	(%rdi,%r9,4), %rax
	cmpq	%rdx, %rax
	seta	%r11b
	leaq	(%rsi,%r9,4), %rax
	cmpq	%rdi, %rcx
	seta	%bl
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%r10d, %r10d
	testb	%bl, %r11b
	popq	%rbx
	popq	%rbp
	jne	LBB3_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB3_3
## %bb.11:
	movl	%r9d, %r10d
	andl	$-32, %r10d
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB3_12:                                ## =>This Inner Loop Header: Depth=1
	vmovdqu	32(%rdi,%rax,4), %ymm0
	vmovdqu	(%rsi,%rax,4), %ymm1
	vmovdqu	64(%rsi,%rax,4), %ymm2
	vmovdqu	96(%rsi,%rax,4), %ymm3
	vpaddd	(%rdi,%rax,4), %ymm1, %ymm1
	vpaddd	32(%rsi,%rax,4), %ymm0, %ymm0
	vpaddd	64(%rdi,%rax,4), %ymm2, %ymm2
	vpaddd	96(%rdi,%rax,4), %ymm3, %ymm3
	vmovdqu	%ymm1, (%rdx,%rax,4)
	vmovdqu	%ymm0, 32(%rdx,%rax,4)
	vmovdqu	%ymm2, 64(%rdx,%rax,4)
	vmovdqu	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %r10
	jne	LBB3_12
## %bb.13:
	cmpq	%r9, %r10
	je	LBB3_14
LBB3_3:
	movq	%r10, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB3_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB3_5:                                 ## =>This Inner Loop Header: Depth=1
	movl	(%rsi,%r10,4), %ecx
	addl	(%rdi,%r10,4), %ecx
	movl	%ecx, (%rdx,%r10,4)
	incq	%r10
	incq	%rax
	jne	LBB3_5
LBB3_6:
	cmpq	$3, %r8
	jb	LBB3_14
## %bb.7:
	subq	%r10, %r9
	leaq	12(%rdx,%r10,4), %rdx
	leaq	12(%rsi,%r10,4), %rsi
	leaq	12(%rdi,%r10,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB3_8:                                 ## =>This Inner Loop Header: Depth=1
	movl	-12(%rsi,%rdi,4), %eax
	addl	-12(%rcx,%rdi,4), %eax
	movl	%eax, -12(%rdx,%rdi,4)
	movl	-8(%rsi,%rdi,4), %eax
	addl	-8(%rcx,%rdi,4), %eax
	movl	%eax, -8(%rdx,%rdi,4)
	movl	-4(%rsi,%rdi,4), %eax
	addl	-4(%rcx,%rdi,4), %eax
	movl	%eax, -4(%rdx,%rdi,4)
	movl	(%rsi,%rdi,4), %eax
	addl	(%rcx,%rdi,4), %eax
	movl	%eax, (%rdx,%rdi,4)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB3_8
LBB3_14:
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sub_f             ## -- Begin function jnvi_sub_f
	.p2align	4, 0x90
_jnvi_sub_f:                            ## @jnvi_sub_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB4_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$31, %ecx
	ja	LBB4_9
## %bb.2:
	xorl	%ecx, %ecx
	jmp	LBB4_3
LBB4_9:
	leaq	(%rdx,%r9,4), %rcx
	leaq	(%rdi,%r9,4), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r9,4), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB4_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB4_3
## %bb.11:
	movl	%r9d, %ecx
	andl	$-32, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB4_12:                                ## =>This Inner Loop Header: Depth=1
	vmovups	(%rdi,%rax,4), %ymm0
	vmovups	32(%rdi,%rax,4), %ymm1
	vmovups	64(%rdi,%rax,4), %ymm2
	vmovups	96(%rdi,%rax,4), %ymm3
	vsubps	(%rsi,%rax,4), %ymm0, %ymm0
	vsubps	32(%rsi,%rax,4), %ymm1, %ymm1
	vsubps	64(%rsi,%rax,4), %ymm2, %ymm2
	vsubps	96(%rsi,%rax,4), %ymm3, %ymm3
	vmovups	%ymm0, (%rdx,%rax,4)
	vmovups	%ymm1, 32(%rdx,%rax,4)
	vmovups	%ymm2, 64(%rdx,%rax,4)
	vmovups	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %rcx
	jne	LBB4_12
## %bb.13:
	cmpq	%r9, %rcx
	je	LBB4_14
LBB4_3:
	movq	%rcx, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB4_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB4_5:                                 ## =>This Inner Loop Header: Depth=1
	vmovss	(%rdi,%rcx,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vsubss	(%rsi,%rcx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rcx,4)
	incq	%rcx
	incq	%rax
	jne	LBB4_5
LBB4_6:
	cmpq	$3, %r8
	jb	LBB4_14
## %bb.7:
	subq	%rcx, %r9
	leaq	12(%rdx,%rcx,4), %rdx
	leaq	12(%rsi,%rcx,4), %rsi
	leaq	12(%rdi,%rcx,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB4_8:                                 ## =>This Inner Loop Header: Depth=1
	vmovss	-12(%rcx,%rdi,4), %xmm0 ## xmm0 = mem[0],zero,zero,zero
	vsubss	-12(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -12(%rdx,%rdi,4)
	vmovss	-8(%rcx,%rdi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vsubss	-8(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -8(%rdx,%rdi,4)
	vmovss	-4(%rcx,%rdi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vsubss	-4(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -4(%rdx,%rdi,4)
	vmovss	(%rcx,%rdi,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vsubss	(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rdi,4)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB4_8
LBB4_14:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sub_d             ## -- Begin function jnvi_sub_d
	.p2align	4, 0x90
_jnvi_sub_d:                            ## @jnvi_sub_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB5_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$15, %ecx
	ja	LBB5_9
## %bb.2:
	xorl	%ecx, %ecx
	jmp	LBB5_3
LBB5_9:
	leaq	(%rdx,%r9,8), %rcx
	leaq	(%rdi,%r9,8), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r9,8), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB5_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB5_3
## %bb.11:
	movl	%r9d, %ecx
	andl	$-16, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB5_12:                                ## =>This Inner Loop Header: Depth=1
	vmovupd	(%rdi,%rax,8), %ymm0
	vmovupd	32(%rdi,%rax,8), %ymm1
	vmovupd	64(%rdi,%rax,8), %ymm2
	vmovupd	96(%rdi,%rax,8), %ymm3
	vsubpd	(%rsi,%rax,8), %ymm0, %ymm0
	vsubpd	32(%rsi,%rax,8), %ymm1, %ymm1
	vsubpd	64(%rsi,%rax,8), %ymm2, %ymm2
	vsubpd	96(%rsi,%rax,8), %ymm3, %ymm3
	vmovupd	%ymm0, (%rdx,%rax,8)
	vmovupd	%ymm1, 32(%rdx,%rax,8)
	vmovupd	%ymm2, 64(%rdx,%rax,8)
	vmovupd	%ymm3, 96(%rdx,%rax,8)
	addq	$16, %rax
	cmpq	%rax, %rcx
	jne	LBB5_12
## %bb.13:
	cmpq	%r9, %rcx
	je	LBB5_14
LBB5_3:
	movq	%rcx, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB5_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB5_5:                                 ## =>This Inner Loop Header: Depth=1
	vmovsd	(%rdi,%rcx,8), %xmm0    ## xmm0 = mem[0],zero
	vsubsd	(%rsi,%rcx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%rcx,8)
	incq	%rcx
	incq	%rax
	jne	LBB5_5
LBB5_6:
	cmpq	$3, %r8
	jb	LBB5_14
## %bb.7:
	subq	%rcx, %r9
	leaq	24(%rdx,%rcx,8), %rdx
	leaq	24(%rsi,%rcx,8), %rsi
	leaq	24(%rdi,%rcx,8), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB5_8:                                 ## =>This Inner Loop Header: Depth=1
	vmovsd	-24(%rcx,%rdi,8), %xmm0 ## xmm0 = mem[0],zero
	vsubsd	-24(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -24(%rdx,%rdi,8)
	vmovsd	-16(%rcx,%rdi,8), %xmm0 ## xmm0 = mem[0],zero
	vsubsd	-16(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -16(%rdx,%rdi,8)
	vmovsd	-8(%rcx,%rdi,8), %xmm0  ## xmm0 = mem[0],zero
	vsubsd	-8(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -8(%rdx,%rdi,8)
	vmovsd	(%rcx,%rdi,8), %xmm0    ## xmm0 = mem[0],zero
	vsubsd	(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%rdi,8)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB5_8
LBB5_14:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sub_i             ## -- Begin function jnvi_sub_i
	.p2align	4, 0x90
_jnvi_sub_i:                            ## @jnvi_sub_i
	.cfi_startproc
## %bb.0:
	testl	%ecx, %ecx
	jle	LBB6_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$31, %ecx
	ja	LBB6_9
## %bb.2:
	xorl	%r10d, %r10d
	jmp	LBB6_3
LBB6_9:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	.cfi_offset %rbx, -24
	leaq	(%rdx,%r9,4), %rcx
	leaq	(%rdi,%r9,4), %rax
	cmpq	%rdx, %rax
	seta	%r11b
	leaq	(%rsi,%r9,4), %rax
	cmpq	%rdi, %rcx
	seta	%bl
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%r10d, %r10d
	testb	%bl, %r11b
	popq	%rbx
	popq	%rbp
	jne	LBB6_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB6_3
## %bb.11:
	movl	%r9d, %r10d
	andl	$-32, %r10d
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB6_12:                                ## =>This Inner Loop Header: Depth=1
	vmovdqu	(%rdi,%rax,4), %ymm0
	vmovdqu	32(%rdi,%rax,4), %ymm1
	vmovdqu	64(%rdi,%rax,4), %ymm2
	vmovdqu	96(%rdi,%rax,4), %ymm3
	vpsubd	(%rsi,%rax,4), %ymm0, %ymm0
	vpsubd	32(%rsi,%rax,4), %ymm1, %ymm1
	vpsubd	64(%rsi,%rax,4), %ymm2, %ymm2
	vpsubd	96(%rsi,%rax,4), %ymm3, %ymm3
	vmovdqu	%ymm0, (%rdx,%rax,4)
	vmovdqu	%ymm1, 32(%rdx,%rax,4)
	vmovdqu	%ymm2, 64(%rdx,%rax,4)
	vmovdqu	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %r10
	jne	LBB6_12
## %bb.13:
	cmpq	%r9, %r10
	je	LBB6_14
LBB6_3:
	movq	%r10, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB6_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB6_5:                                 ## =>This Inner Loop Header: Depth=1
	movl	(%rdi,%r10,4), %ecx
	subl	(%rsi,%r10,4), %ecx
	movl	%ecx, (%rdx,%r10,4)
	incq	%r10
	incq	%rax
	jne	LBB6_5
LBB6_6:
	cmpq	$3, %r8
	jb	LBB6_14
## %bb.7:
	subq	%r10, %r9
	leaq	12(%rdx,%r10,4), %rdx
	leaq	12(%rsi,%r10,4), %rsi
	leaq	12(%rdi,%r10,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB6_8:                                 ## =>This Inner Loop Header: Depth=1
	movl	-12(%rcx,%rdi,4), %eax
	subl	-12(%rsi,%rdi,4), %eax
	movl	%eax, -12(%rdx,%rdi,4)
	movl	-8(%rcx,%rdi,4), %eax
	subl	-8(%rsi,%rdi,4), %eax
	movl	%eax, -8(%rdx,%rdi,4)
	movl	-4(%rcx,%rdi,4), %eax
	subl	-4(%rsi,%rdi,4), %eax
	movl	%eax, -4(%rdx,%rdi,4)
	movl	(%rcx,%rdi,4), %eax
	subl	(%rsi,%rdi,4), %eax
	movl	%eax, (%rdx,%rdi,4)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB6_8
LBB6_14:
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_mul_f             ## -- Begin function jnvi_mul_f
	.p2align	4, 0x90
_jnvi_mul_f:                            ## @jnvi_mul_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB7_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$31, %ecx
	ja	LBB7_9
## %bb.2:
	xorl	%ecx, %ecx
	jmp	LBB7_3
LBB7_9:
	leaq	(%rdx,%r9,4), %rcx
	leaq	(%rdi,%r9,4), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r9,4), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB7_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB7_3
## %bb.11:
	movl	%r9d, %ecx
	andl	$-32, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB7_12:                                ## =>This Inner Loop Header: Depth=1
	vmovups	(%rdi,%rax,4), %ymm0
	vmovups	32(%rdi,%rax,4), %ymm1
	vmovups	64(%rdi,%rax,4), %ymm2
	vmovups	96(%rdi,%rax,4), %ymm3
	vmulps	(%rsi,%rax,4), %ymm0, %ymm0
	vmulps	32(%rsi,%rax,4), %ymm1, %ymm1
	vmulps	64(%rsi,%rax,4), %ymm2, %ymm2
	vmulps	96(%rsi,%rax,4), %ymm3, %ymm3
	vmovups	%ymm0, (%rdx,%rax,4)
	vmovups	%ymm1, 32(%rdx,%rax,4)
	vmovups	%ymm2, 64(%rdx,%rax,4)
	vmovups	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %rcx
	jne	LBB7_12
## %bb.13:
	cmpq	%r9, %rcx
	je	LBB7_14
LBB7_3:
	movq	%rcx, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB7_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB7_5:                                 ## =>This Inner Loop Header: Depth=1
	vmovss	(%rdi,%rcx,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vmulss	(%rsi,%rcx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rcx,4)
	incq	%rcx
	incq	%rax
	jne	LBB7_5
LBB7_6:
	cmpq	$3, %r8
	jb	LBB7_14
## %bb.7:
	subq	%rcx, %r9
	leaq	12(%rdx,%rcx,4), %rdx
	leaq	12(%rsi,%rcx,4), %rsi
	leaq	12(%rdi,%rcx,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB7_8:                                 ## =>This Inner Loop Header: Depth=1
	vmovss	-12(%rcx,%rdi,4), %xmm0 ## xmm0 = mem[0],zero,zero,zero
	vmulss	-12(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -12(%rdx,%rdi,4)
	vmovss	-8(%rcx,%rdi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vmulss	-8(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -8(%rdx,%rdi,4)
	vmovss	-4(%rcx,%rdi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vmulss	-4(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, -4(%rdx,%rdi,4)
	vmovss	(%rcx,%rdi,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vmulss	(%rsi,%rdi,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rdi,4)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB7_8
LBB7_14:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_mul_d             ## -- Begin function jnvi_mul_d
	.p2align	4, 0x90
_jnvi_mul_d:                            ## @jnvi_mul_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB8_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$15, %ecx
	ja	LBB8_9
## %bb.2:
	xorl	%ecx, %ecx
	jmp	LBB8_3
LBB8_9:
	leaq	(%rdx,%r9,8), %rcx
	leaq	(%rdi,%r9,8), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r9,8), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB8_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB8_3
## %bb.11:
	movl	%r9d, %ecx
	andl	$-16, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB8_12:                                ## =>This Inner Loop Header: Depth=1
	vmovupd	(%rdi,%rax,8), %ymm0
	vmovupd	32(%rdi,%rax,8), %ymm1
	vmovupd	64(%rdi,%rax,8), %ymm2
	vmovupd	96(%rdi,%rax,8), %ymm3
	vmulpd	(%rsi,%rax,8), %ymm0, %ymm0
	vmulpd	32(%rsi,%rax,8), %ymm1, %ymm1
	vmulpd	64(%rsi,%rax,8), %ymm2, %ymm2
	vmulpd	96(%rsi,%rax,8), %ymm3, %ymm3
	vmovupd	%ymm0, (%rdx,%rax,8)
	vmovupd	%ymm1, 32(%rdx,%rax,8)
	vmovupd	%ymm2, 64(%rdx,%rax,8)
	vmovupd	%ymm3, 96(%rdx,%rax,8)
	addq	$16, %rax
	cmpq	%rax, %rcx
	jne	LBB8_12
## %bb.13:
	cmpq	%r9, %rcx
	je	LBB8_14
LBB8_3:
	movq	%rcx, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB8_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB8_5:                                 ## =>This Inner Loop Header: Depth=1
	vmovsd	(%rdi,%rcx,8), %xmm0    ## xmm0 = mem[0],zero
	vmulsd	(%rsi,%rcx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%rcx,8)
	incq	%rcx
	incq	%rax
	jne	LBB8_5
LBB8_6:
	cmpq	$3, %r8
	jb	LBB8_14
## %bb.7:
	subq	%rcx, %r9
	leaq	24(%rdx,%rcx,8), %rdx
	leaq	24(%rsi,%rcx,8), %rsi
	leaq	24(%rdi,%rcx,8), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB8_8:                                 ## =>This Inner Loop Header: Depth=1
	vmovsd	-24(%rcx,%rdi,8), %xmm0 ## xmm0 = mem[0],zero
	vmulsd	-24(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -24(%rdx,%rdi,8)
	vmovsd	-16(%rcx,%rdi,8), %xmm0 ## xmm0 = mem[0],zero
	vmulsd	-16(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -16(%rdx,%rdi,8)
	vmovsd	-8(%rcx,%rdi,8), %xmm0  ## xmm0 = mem[0],zero
	vmulsd	-8(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -8(%rdx,%rdi,8)
	vmovsd	(%rcx,%rdi,8), %xmm0    ## xmm0 = mem[0],zero
	vmulsd	(%rsi,%rdi,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%rdi,8)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB8_8
LBB8_14:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_mul_i             ## -- Begin function jnvi_mul_i
	.p2align	4, 0x90
_jnvi_mul_i:                            ## @jnvi_mul_i
	.cfi_startproc
## %bb.0:
	testl	%ecx, %ecx
	jle	LBB9_14
## %bb.1:
	movl	%ecx, %r9d
	cmpl	$31, %ecx
	ja	LBB9_9
## %bb.2:
	xorl	%r10d, %r10d
	jmp	LBB9_3
LBB9_9:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	.cfi_offset %rbx, -24
	leaq	(%rdx,%r9,4), %rcx
	leaq	(%rdi,%r9,4), %rax
	cmpq	%rdx, %rax
	seta	%r11b
	leaq	(%rsi,%r9,4), %rax
	cmpq	%rdi, %rcx
	seta	%bl
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r8b
	xorl	%r10d, %r10d
	testb	%bl, %r11b
	popq	%rbx
	popq	%rbp
	jne	LBB9_3
## %bb.10:
	andb	%r8b, %al
	jne	LBB9_3
## %bb.11:
	movl	%r9d, %r10d
	andl	$-32, %r10d
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB9_12:                                ## =>This Inner Loop Header: Depth=1
	vmovdqu	32(%rdi,%rax,4), %ymm0
	vmovdqu	(%rsi,%rax,4), %ymm1
	vmovdqu	64(%rsi,%rax,4), %ymm2
	vmovdqu	96(%rsi,%rax,4), %ymm3
	vpmulld	(%rdi,%rax,4), %ymm1, %ymm1
	vpmulld	32(%rsi,%rax,4), %ymm0, %ymm0
	vpmulld	64(%rdi,%rax,4), %ymm2, %ymm2
	vpmulld	96(%rdi,%rax,4), %ymm3, %ymm3
	vmovdqu	%ymm1, (%rdx,%rax,4)
	vmovdqu	%ymm0, 32(%rdx,%rax,4)
	vmovdqu	%ymm2, 64(%rdx,%rax,4)
	vmovdqu	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %r10
	jne	LBB9_12
## %bb.13:
	cmpq	%r9, %r10
	je	LBB9_14
LBB9_3:
	movq	%r10, %rax
	negq	%rax
	leaq	-1(%r9,%rax), %r8
	movq	%r9, %rax
	andq	$3, %rax
	je	LBB9_6
## %bb.4:
	negq	%rax
	.p2align	4, 0x90
LBB9_5:                                 ## =>This Inner Loop Header: Depth=1
	movl	(%rsi,%r10,4), %ecx
	imull	(%rdi,%r10,4), %ecx
	movl	%ecx, (%rdx,%r10,4)
	incq	%r10
	incq	%rax
	jne	LBB9_5
LBB9_6:
	cmpq	$3, %r8
	jb	LBB9_14
## %bb.7:
	subq	%r10, %r9
	leaq	12(%rdx,%r10,4), %rdx
	leaq	12(%rsi,%r10,4), %rsi
	leaq	12(%rdi,%r10,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB9_8:                                 ## =>This Inner Loop Header: Depth=1
	movl	-12(%rsi,%rdi,4), %eax
	imull	-12(%rcx,%rdi,4), %eax
	movl	%eax, -12(%rdx,%rdi,4)
	movl	-8(%rsi,%rdi,4), %eax
	imull	-8(%rcx,%rdi,4), %eax
	movl	%eax, -8(%rdx,%rdi,4)
	movl	-4(%rsi,%rdi,4), %eax
	imull	-4(%rcx,%rdi,4), %eax
	movl	%eax, -4(%rdx,%rdi,4)
	movl	(%rsi,%rdi,4), %eax
	imull	(%rcx,%rdi,4), %eax
	movl	%eax, (%rdx,%rdi,4)
	addq	$4, %rdi
	cmpq	%rdi, %r9
	jne	LBB9_8
LBB9_14:
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_div_f             ## -- Begin function jnvi_div_f
	.p2align	4, 0x90
_jnvi_div_f:                            ## @jnvi_div_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB10_13
## %bb.1:
	movl	%ecx, %r8d
	cmpl	$31, %ecx
	ja	LBB10_8
## %bb.2:
	xorl	%ecx, %ecx
	leaq	-1(%r8), %rax
	movq	%rcx, %r9
	testb	$1, %r8b
	jne	LBB10_4
	jmp	LBB10_5
LBB10_8:
	leaq	(%rdx,%r8,4), %rcx
	leaq	(%rdi,%r8,4), %rax
	cmpq	%rdx, %rax
	seta	%r10b
	leaq	(%rsi,%r8,4), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%r9b
	xorl	%ecx, %ecx
	testb	%r11b, %r10b
	jne	LBB10_3
## %bb.9:
	andb	%r9b, %al
	jne	LBB10_3
## %bb.10:
	movl	%r8d, %ecx
	andl	$-32, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB10_11:                               ## =>This Inner Loop Header: Depth=1
	vmovups	(%rdi,%rax,4), %ymm0
	vmovups	32(%rdi,%rax,4), %ymm1
	vmovups	64(%rdi,%rax,4), %ymm2
	vmovups	96(%rdi,%rax,4), %ymm3
	vdivps	(%rsi,%rax,4), %ymm0, %ymm0
	vdivps	32(%rsi,%rax,4), %ymm1, %ymm1
	vdivps	64(%rsi,%rax,4), %ymm2, %ymm2
	vdivps	96(%rsi,%rax,4), %ymm3, %ymm3
	vmovups	%ymm0, (%rdx,%rax,4)
	vmovups	%ymm1, 32(%rdx,%rax,4)
	vmovups	%ymm2, 64(%rdx,%rax,4)
	vmovups	%ymm3, 96(%rdx,%rax,4)
	addq	$32, %rax
	cmpq	%rax, %rcx
	jne	LBB10_11
## %bb.12:
	cmpq	%r8, %rcx
	je	LBB10_13
LBB10_3:
	leaq	-1(%r8), %rax
	movq	%rcx, %r9
	testb	$1, %r8b
	je	LBB10_5
LBB10_4:
	vmovss	(%rdi,%rcx,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vdivss	(%rsi,%rcx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rdx,%rcx,4)
	movq	%rcx, %r9
	orq	$1, %r9
LBB10_5:
	cmpq	%rcx, %rax
	je	LBB10_13
## %bb.6:
	subq	%r9, %r8
	leaq	4(%rdx,%r9,4), %rax
	leaq	4(%rsi,%r9,4), %rcx
	leaq	4(%rdi,%r9,4), %rdx
	xorl	%esi, %esi
	.p2align	4, 0x90
LBB10_7:                                ## =>This Inner Loop Header: Depth=1
	vmovss	-4(%rdx,%rsi,4), %xmm0  ## xmm0 = mem[0],zero,zero,zero
	vdivss	-4(%rcx,%rsi,4), %xmm0, %xmm0
	vmovss	%xmm0, -4(%rax,%rsi,4)
	vmovss	(%rdx,%rsi,4), %xmm0    ## xmm0 = mem[0],zero,zero,zero
	vdivss	(%rcx,%rsi,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rax,%rsi,4)
	addq	$2, %rsi
	cmpq	%rsi, %r8
	jne	LBB10_7
LBB10_13:
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_div_d             ## -- Begin function jnvi_div_d
	.p2align	4, 0x90
_jnvi_div_d:                            ## @jnvi_div_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB11_17
## %bb.1:
	movl	%ecx, %r10d
	cmpl	$3, %ecx
	ja	LBB11_8
## %bb.2:
	xorl	%r9d, %r9d
LBB11_3:
	leaq	-1(%r10), %rax
	movq	%r9, %r8
	testb	$1, %r10b
	je	LBB11_5
## %bb.4:
	vmovsd	(%rdi,%r9,8), %xmm0     ## xmm0 = mem[0],zero
	vdivsd	(%rsi,%r9,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx,%r9,8)
	movq	%r9, %r8
	orq	$1, %r8
LBB11_5:
	cmpq	%r9, %rax
	je	LBB11_17
## %bb.6:
	subq	%r8, %r10
	leaq	8(%rdx,%r8,8), %rax
	leaq	8(%rsi,%r8,8), %rcx
	leaq	8(%rdi,%r8,8), %rdx
	xorl	%esi, %esi
	.p2align	4, 0x90
LBB11_7:                                ## =>This Inner Loop Header: Depth=1
	vmovsd	-8(%rdx,%rsi,8), %xmm0  ## xmm0 = mem[0],zero
	vdivsd	-8(%rcx,%rsi,8), %xmm0, %xmm0
	vmovsd	%xmm0, -8(%rax,%rsi,8)
	vmovsd	(%rdx,%rsi,8), %xmm0    ## xmm0 = mem[0],zero
	vdivsd	(%rcx,%rsi,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rax,%rsi,8)
	addq	$2, %rsi
	cmpq	%rsi, %r10
	jne	LBB11_7
	jmp	LBB11_17
LBB11_8:
	leaq	(%rdx,%r10,8), %rcx
	leaq	(%rdi,%r10,8), %rax
	cmpq	%rdx, %rax
	seta	%r8b
	leaq	(%rsi,%r10,8), %rax
	cmpq	%rdi, %rcx
	seta	%r11b
	cmpq	%rdx, %rax
	seta	%al
	cmpq	%rsi, %rcx
	seta	%cl
	xorl	%r9d, %r9d
	testb	%r11b, %r8b
	jne	LBB11_3
## %bb.9:
	andb	%cl, %al
	jne	LBB11_3
## %bb.10:
	movl	%r10d, %r9d
	andl	$-4, %r9d
	leaq	-4(%r9), %rax
	movq	%rax, %rcx
	shrq	$2, %rcx
	leal	1(%rcx), %r8d
	andl	$1, %r8d
	testq	%rax, %rax
	je	LBB11_11
## %bb.12:
	leaq	-1(%r8), %rax
	subq	%rcx, %rax
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB11_13:                               ## =>This Inner Loop Header: Depth=1
	vmovupd	(%rdi,%rcx,8), %ymm0
	vdivpd	(%rsi,%rcx,8), %ymm0, %ymm0
	vmovupd	%ymm0, (%rdx,%rcx,8)
	vmovupd	32(%rdi,%rcx,8), %ymm0
	vdivpd	32(%rsi,%rcx,8), %ymm0, %ymm0
	vmovupd	%ymm0, 32(%rdx,%rcx,8)
	addq	$8, %rcx
	addq	$2, %rax
	jne	LBB11_13
## %bb.14:
	testq	%r8, %r8
	je	LBB11_16
LBB11_15:
	vmovupd	(%rdi,%rcx,8), %ymm0
	vdivpd	(%rsi,%rcx,8), %ymm0, %ymm0
	vmovupd	%ymm0, (%rdx,%rcx,8)
LBB11_16:
	cmpq	%r10, %r9
	jne	LBB11_3
LBB11_17:
	popq	%rbp
	vzeroupper
	retq
LBB11_11:
	xorl	%ecx, %ecx
	testq	%r8, %r8
	jne	LBB11_15
	jmp	LBB11_16
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_div_i             ## -- Begin function jnvi_div_i
	.p2align	4, 0x90
_jnvi_div_i:                            ## @jnvi_div_i
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdx, %r8
	testl	%ecx, %ecx
	jle	LBB12_5
## %bb.1:
	movl	%ecx, %r10d
	movl	%r10d, %r9d
	andl	$1, %r9d
	cmpl	$1, %ecx
	jne	LBB12_6
## %bb.2:
	xorl	%ecx, %ecx
	testq	%r9, %r9
	jne	LBB12_4
	jmp	LBB12_5
LBB12_6:
	subq	%r9, %r10
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB12_7:                                ## =>This Inner Loop Header: Depth=1
	movl	(%rdi,%rcx,4), %eax
	cltd
	idivl	(%rsi,%rcx,4)
	movl	%eax, (%r8,%rcx,4)
	movl	4(%rdi,%rcx,4), %eax
	cltd
	idivl	4(%rsi,%rcx,4)
	movl	%eax, 4(%r8,%rcx,4)
	addq	$2, %rcx
	cmpq	%rcx, %r10
	jne	LBB12_7
## %bb.3:
	testq	%r9, %r9
	je	LBB12_5
LBB12_4:
	movl	(%rdi,%rcx,4), %eax
	cltd
	idivl	(%rsi,%rcx,4)
	movl	%eax, (%r8,%rcx,4)
LBB12_5:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_dot_f             ## -- Begin function jnvi_dot_f
	.p2align	4, 0x90
_jnvi_dot_f:                            ## @jnvi_dot_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB13_6
## %bb.1:
	vmovss	(%rdx), %xmm0           ## xmm0 = mem[0],zero,zero,zero
	movl	%ecx, %eax
	leaq	-1(%rax), %rcx
	movl	%eax, %r8d
	andl	$3, %r8d
	cmpq	$3, %rcx
	jae	LBB13_7
## %bb.2:
	xorl	%ecx, %ecx
	testq	%r8, %r8
	jne	LBB13_4
	jmp	LBB13_6
LBB13_7:
	subq	%r8, %rax
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB13_8:                                ## =>This Inner Loop Header: Depth=1
	vmovss	(%rdi,%rcx,4), %xmm1    ## xmm1 = mem[0],zero,zero,zero
	vmulss	(%rsi,%rcx,4), %xmm1, %xmm1
	vaddss	%xmm1, %xmm0, %xmm0
	vmovss	%xmm0, (%rdx)
	vmovss	4(%rdi,%rcx,4), %xmm1   ## xmm1 = mem[0],zero,zero,zero
	vmulss	4(%rsi,%rcx,4), %xmm1, %xmm1
	vaddss	%xmm1, %xmm0, %xmm0
	vmovss	%xmm0, (%rdx)
	vmovss	8(%rdi,%rcx,4), %xmm1   ## xmm1 = mem[0],zero,zero,zero
	vmulss	8(%rsi,%rcx,4), %xmm1, %xmm1
	vaddss	%xmm1, %xmm0, %xmm0
	vmovss	%xmm0, (%rdx)
	vmovss	12(%rdi,%rcx,4), %xmm1  ## xmm1 = mem[0],zero,zero,zero
	vmulss	12(%rsi,%rcx,4), %xmm1, %xmm1
	vaddss	%xmm1, %xmm0, %xmm0
	vmovss	%xmm0, (%rdx)
	addq	$4, %rcx
	cmpq	%rcx, %rax
	jne	LBB13_8
## %bb.3:
	testq	%r8, %r8
	je	LBB13_6
LBB13_4:
	leaq	(%rsi,%rcx,4), %rax
	leaq	(%rdi,%rcx,4), %rcx
	xorl	%esi, %esi
	.p2align	4, 0x90
LBB13_5:                                ## =>This Inner Loop Header: Depth=1
	vmovss	(%rcx,%rsi,4), %xmm1    ## xmm1 = mem[0],zero,zero,zero
	vmulss	(%rax,%rsi,4), %xmm1, %xmm1
	vaddss	%xmm1, %xmm0, %xmm0
	vmovss	%xmm0, (%rdx)
	incq	%rsi
	cmpq	%rsi, %r8
	jne	LBB13_5
LBB13_6:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_dot_d             ## -- Begin function jnvi_dot_d
	.p2align	4, 0x90
_jnvi_dot_d:                            ## @jnvi_dot_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB14_6
## %bb.1:
	vmovsd	(%rdx), %xmm0           ## xmm0 = mem[0],zero
	movl	%ecx, %eax
	leaq	-1(%rax), %rcx
	movl	%eax, %r8d
	andl	$3, %r8d
	cmpq	$3, %rcx
	jae	LBB14_7
## %bb.2:
	xorl	%ecx, %ecx
	testq	%r8, %r8
	jne	LBB14_4
	jmp	LBB14_6
LBB14_7:
	subq	%r8, %rax
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB14_8:                                ## =>This Inner Loop Header: Depth=1
	vmovsd	(%rdi,%rcx,8), %xmm1    ## xmm1 = mem[0],zero
	vmulsd	(%rsi,%rcx,8), %xmm1, %xmm1
	vaddsd	%xmm1, %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx)
	vmovsd	8(%rdi,%rcx,8), %xmm1   ## xmm1 = mem[0],zero
	vmulsd	8(%rsi,%rcx,8), %xmm1, %xmm1
	vaddsd	%xmm1, %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx)
	vmovsd	16(%rdi,%rcx,8), %xmm1  ## xmm1 = mem[0],zero
	vmulsd	16(%rsi,%rcx,8), %xmm1, %xmm1
	vaddsd	%xmm1, %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx)
	vmovsd	24(%rdi,%rcx,8), %xmm1  ## xmm1 = mem[0],zero
	vmulsd	24(%rsi,%rcx,8), %xmm1, %xmm1
	vaddsd	%xmm1, %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx)
	addq	$4, %rcx
	cmpq	%rcx, %rax
	jne	LBB14_8
## %bb.3:
	testq	%r8, %r8
	je	LBB14_6
LBB14_4:
	leaq	(%rsi,%rcx,8), %rax
	leaq	(%rdi,%rcx,8), %rcx
	xorl	%esi, %esi
	.p2align	4, 0x90
LBB14_5:                                ## =>This Inner Loop Header: Depth=1
	vmovsd	(%rcx,%rsi,8), %xmm1    ## xmm1 = mem[0],zero
	vmulsd	(%rax,%rsi,8), %xmm1, %xmm1
	vaddsd	%xmm1, %xmm0, %xmm0
	vmovsd	%xmm0, (%rdx)
	incq	%rsi
	cmpq	%rsi, %r8
	jne	LBB14_5
LBB14_6:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_dot_i             ## -- Begin function jnvi_dot_i
	.p2align	4, 0x90
_jnvi_dot_i:                            ## @jnvi_dot_i
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%ecx, %ecx
	jle	LBB15_6
## %bb.1:
	movl	(%rdx), %eax
	movl	%ecx, %r9d
	leaq	-1(%r9), %rcx
	movl	%r9d, %r8d
	andl	$3, %r8d
	cmpq	$3, %rcx
	jae	LBB15_7
## %bb.2:
	xorl	%r10d, %r10d
	testq	%r8, %r8
	jne	LBB15_4
	jmp	LBB15_6
LBB15_7:
	subq	%r8, %r9
	xorl	%r10d, %r10d
	.p2align	4, 0x90
LBB15_8:                                ## =>This Inner Loop Header: Depth=1
	movl	(%rsi,%r10,4), %ecx
	imull	(%rdi,%r10,4), %ecx
	addl	%eax, %ecx
	movl	%ecx, (%rdx)
	movl	4(%rsi,%r10,4), %eax
	imull	4(%rdi,%r10,4), %eax
	addl	%ecx, %eax
	movl	%eax, (%rdx)
	movl	8(%rsi,%r10,4), %ecx
	imull	8(%rdi,%r10,4), %ecx
	addl	%eax, %ecx
	movl	%ecx, (%rdx)
	movl	12(%rsi,%r10,4), %eax
	imull	12(%rdi,%r10,4), %eax
	addl	%ecx, %eax
	movl	%eax, (%rdx)
	addq	$4, %r10
	cmpq	%r10, %r9
	jne	LBB15_8
## %bb.3:
	testq	%r8, %r8
	je	LBB15_6
LBB15_4:
	leaq	(%rsi,%r10,4), %r9
	leaq	(%rdi,%r10,4), %rcx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB15_5:                                ## =>This Inner Loop Header: Depth=1
	movl	(%r9,%rdi,4), %esi
	imull	(%rcx,%rdi,4), %esi
	addl	%esi, %eax
	movl	%eax, (%rdx)
	incq	%rdi
	cmpq	%rdi, %r8
	jne	LBB15_5
LBB15_6:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sum_f             ## -- Begin function jnvi_sum_f
	.p2align	4, 0x90
_jnvi_sum_f:                            ## @jnvi_sum_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%edx, %edx
	jle	LBB16_6
## %bb.1:
	vmovss	(%rsi), %xmm0           ## xmm0 = mem[0],zero,zero,zero
	movl	%edx, %ecx
	leaq	-1(%rcx), %rdx
	movl	%ecx, %eax
	andl	$3, %eax
	cmpq	$3, %rdx
	jae	LBB16_7
## %bb.2:
	xorl	%edx, %edx
	testq	%rax, %rax
	jne	LBB16_4
	jmp	LBB16_6
LBB16_7:
	subq	%rax, %rcx
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB16_8:                                ## =>This Inner Loop Header: Depth=1
	vaddss	(%rdi,%rdx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rsi)
	vaddss	4(%rdi,%rdx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rsi)
	vaddss	8(%rdi,%rdx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rsi)
	vaddss	12(%rdi,%rdx,4), %xmm0, %xmm0
	vmovss	%xmm0, (%rsi)
	addq	$4, %rdx
	cmpq	%rdx, %rcx
	jne	LBB16_8
## %bb.3:
	testq	%rax, %rax
	je	LBB16_6
LBB16_4:
	leaq	(%rdi,%rdx,4), %rcx
	negq	%rax
	.p2align	4, 0x90
LBB16_5:                                ## =>This Inner Loop Header: Depth=1
	vaddss	(%rcx), %xmm0, %xmm0
	vmovss	%xmm0, (%rsi)
	addq	$4, %rcx
	incq	%rax
	jne	LBB16_5
LBB16_6:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sum_d             ## -- Begin function jnvi_sum_d
	.p2align	4, 0x90
_jnvi_sum_d:                            ## @jnvi_sum_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%edx, %edx
	jle	LBB17_6
## %bb.1:
	vmovsd	(%rsi), %xmm0           ## xmm0 = mem[0],zero
	movl	%edx, %ecx
	leaq	-1(%rcx), %rdx
	movl	%ecx, %eax
	andl	$3, %eax
	cmpq	$3, %rdx
	jae	LBB17_7
## %bb.2:
	xorl	%edx, %edx
	testq	%rax, %rax
	jne	LBB17_4
	jmp	LBB17_6
LBB17_7:
	subq	%rax, %rcx
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB17_8:                                ## =>This Inner Loop Header: Depth=1
	vaddsd	(%rdi,%rdx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rsi)
	vaddsd	8(%rdi,%rdx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rsi)
	vaddsd	16(%rdi,%rdx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rsi)
	vaddsd	24(%rdi,%rdx,8), %xmm0, %xmm0
	vmovsd	%xmm0, (%rsi)
	addq	$4, %rdx
	cmpq	%rdx, %rcx
	jne	LBB17_8
## %bb.3:
	testq	%rax, %rax
	je	LBB17_6
LBB17_4:
	leaq	(%rdi,%rdx,8), %rcx
	negq	%rax
	.p2align	4, 0x90
LBB17_5:                                ## =>This Inner Loop Header: Depth=1
	vaddsd	(%rcx), %xmm0, %xmm0
	vmovsd	%xmm0, (%rsi)
	addq	$8, %rcx
	incq	%rax
	jne	LBB17_5
LBB17_6:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sum_i             ## -- Begin function jnvi_sum_i
	.p2align	4, 0x90
_jnvi_sum_i:                            ## @jnvi_sum_i
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	testl	%edx, %edx
	jle	LBB18_6
## %bb.1:
	movl	(%rsi), %eax
	movl	%edx, %r8d
	leaq	-1(%r8), %rdx
	movl	%r8d, %ecx
	andl	$3, %ecx
	cmpq	$3, %rdx
	jae	LBB18_7
## %bb.2:
	xorl	%edx, %edx
	testq	%rcx, %rcx
	jne	LBB18_4
	jmp	LBB18_6
LBB18_7:
	subq	%rcx, %r8
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB18_8:                                ## =>This Inner Loop Header: Depth=1
	addl	(%rdi,%rdx,4), %eax
	movl	%eax, (%rsi)
	addl	4(%rdi,%rdx,4), %eax
	movl	%eax, (%rsi)
	addl	8(%rdi,%rdx,4), %eax
	movl	%eax, (%rsi)
	addl	12(%rdi,%rdx,4), %eax
	movl	%eax, (%rsi)
	addq	$4, %rdx
	cmpq	%rdx, %r8
	jne	LBB18_8
## %bb.3:
	testq	%rcx, %rcx
	je	LBB18_6
LBB18_4:
	leaq	(%rdi,%rdx,4), %rdx
	negq	%rcx
	.p2align	4, 0x90
LBB18_5:                                ## =>This Inner Loop Header: Depth=1
	addl	(%rdx), %eax
	movl	%eax, (%rsi)
	addq	$4, %rdx
	incq	%rcx
	jne	LBB18_5
LBB18_6:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sqrt_d            ## -- Begin function jnvi_sqrt_d
	.p2align	4, 0x90
_jnvi_sqrt_d:                           ## @jnvi_sqrt_d
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	vsqrtpd	(%rdi), %ymm0
	vmovupd	%ymm0, (%rsi)
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_sqrt_f            ## -- Begin function jnvi_sqrt_f
	.p2align	4, 0x90
_jnvi_sqrt_f:                           ## @jnvi_sqrt_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	vsqrtps	(%rdi), %ymm0
	vmovups	%ymm0, (%rsi)
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_jnvi_rsqrt_f           ## -- Begin function jnvi_rsqrt_f
	.p2align	4, 0x90
_jnvi_rsqrt_f:                          ## @jnvi_rsqrt_f
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	vrsqrtps	(%rdi), %ymm0
	vmovups	%ymm0, (%rsi)
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
