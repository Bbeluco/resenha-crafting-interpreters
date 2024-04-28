PROJ_NAME=doubly

CC=gcc
CC_FLAGS = -c -W -Wall -ansi -pedantic

C_SOURCE=$(wildcard ./source/*.c)
H_SOURCE=$(wildcard ./source/*.h)

OBJ=$(subst .c,.o,$(subst source,objects,$(C_SOURCE)))

CC_FLAGS = -c -W -Wall -ansi -pedantic

RM=rm -rf

all: objFolder $(PROJ_NAME)

$(PROJ_NAME): $(OBJ)
	$(CC) $^ -o $@

./objects/main.o: ./source/main.c $(H_SOURCE)
	$(CC) $< -o $@ $(CC_FLAGS)

./objects/%.o: ./source/%.c ./source/%.h
	$(CC) $< -o $@ $(CC_FLAGS)

objFolder:
	@ mkdir objects

clean:
	@ $(RM) ./objects/*.o ./objects/*~ $(PROJ_NAME)
	@ rmdir objects