#My first make file

#Name of the project
PROJ_NAME = printy

#get all .c files
C_SOURCE = $(wildcard ./source/*.c)

#get all .h files

H_SOURCE = $(wildcard ./source/*.h)

# Obj files
OBJ = $(subst .c,.o,$(subst source,objects,$(C_SOURCE)))

#Compiler
CC = gcc

# Flags
CC_FLAGS = -c -W -Wall -ansi -pedantic

#Remove all
RM = rm -rf

all: objFolder $(PROJ_NAME)

$(PROJ_NAME): $(OBJ)
	@ echo "Building binary using GCC Compiler: $@"
	$(CC) -o $@ $^
	@ echo "Finished building binary using GCC Compiler: $@\n"

./objects/main.o: ./source/main.c $(H_SOURCE)
	@ echo "Building binary using GCC Compiler: $<"
	$(CC) $< -o $@ $(CC_FLAGS)
	@ echo ' '

./objects/%.o: ./source/%.c ./source/%.h
	@ echo "Building binary using GCC Compiler: $<"
	$(CC) $< -o $@ $(CC_FLAGS)
	@ echo ' '

objFolder:
	@ mkdir objects

clean:
	@ $(RM) ./objects/*.o *~ $(PROJ_NAME)
	@ rmdir objects