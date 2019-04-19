CC=
CFLAGS=-Ijdk1.8.0_60/Home/include/ -Wall

JAVAC=javac

NATIVE_HEADERS=src/main/c/include
API_SOURCES=src/main/java/uk/ac/hud/jnvi/api/*
NATIVE_SOURCES=src/main/c/src/*
LIB_DIR=src/main/resources/natives/

LIB_NAME=

ifeq ($(TARGET), darwin64)
	CC=gcc
	CFLAGS+=-Ijdk1.8.0_60/Home/include/darwin
	LIB_NAME=jnvi-lib.jnilib
endif

CFLAGS+= -msse -msse2 -msse3 -mssse3 -msse4.1 -msse4.2 -mavx -mavx2 -mfma
CFLAGS+=-O3
#CFLAGS+=-funroll-loops
#CFLAGS+=-W

all: headers clean lib dir

# ----- STEP 1: Generate headers from uk/ac/hud/jnvi/api package. -----

headers:
	$(JAVAC) -h $(NATIVE_HEADERS) $(API_SOURCES)

# ----- STEP 2: Remove API class files. -----

clean:
	rm $(wildcard $(API_SOURCES).class)

# ----- STEP 3: Compile native library. -----

lib:
	$(CC) $(CFLAGS) -o $(LIB_NAME) -shared $(NATIVE_SOURCES)

# ----- STEP 4: Move natives to directory. -----

dir:
	mv $(LIB_NAME) $(LIB_DIR)

	@echo ""
	@echo "------------------------------------------------------------------------"
	@echo ""
	@echo ""
	@echo "Successfully built Java Native Vectorisation Library (JNVI)"
	@echo ""
	@echo ""
	@echo "------------------------------------------------------------------------"
	@echo ""