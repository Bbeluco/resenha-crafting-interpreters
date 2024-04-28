#include "doubly.h"

int main() {
    insert_at_head(3);
    insert_at_head(2);
    delete_at_head();
    insert_at_head(1);
    display_foward();
    insert_at_tail(4);
    delete_at_tail();
    insert_at_tail(5);
    display_backwards();
    return 0;
}