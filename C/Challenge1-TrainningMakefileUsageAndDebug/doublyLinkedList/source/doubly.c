#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int value;
    struct node* prev;
    struct node* next;
}node;

struct node* head = NULL;
struct node* tail = NULL;

struct node* create_node() {
    struct node* new_node = (struct node*) malloc(sizeof(struct node));
    new_node->next = NULL;
    new_node->prev = NULL;
    new_node->value= 0;
    return new_node;
}

void insert_at_head(int v) {
    struct node* new_node = create_node();
    if(head == NULL) {
        head = new_node;
        tail = new_node;
    } else {
        new_node->prev = head;
        head->next = new_node;
        head = new_node;
    }

    head->value = v;
}

void delete_at_head() {
    if(head == NULL) { return; }
    head = head->prev;
    free(head->next);
}

void insert_at_tail(int v) {
    struct node* new_tail = create_node();
    if(tail == NULL) {
        head = new_tail;
        tail = new_tail;
    } else {
        new_tail->next = tail;
        tail->prev = new_tail;
        tail = new_tail;
    }

    tail->value = v;
}

void delete_at_tail() {
    if(tail == NULL) { return; }
    tail = tail->next;
    free(tail->prev);
}

void display_foward() {
    struct node* current = head;
    while(current != NULL) {
        printf("%d ", current->value);
        current = current->prev;
    }

    printf("\n");
}

void display_backwards() {
    struct node* end = tail;
    while(end != NULL) {
        printf("%d ", end->value);
        end = end->next;
    }

    printf("\n");
}