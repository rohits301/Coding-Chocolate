#include <iostream>

using namespace std;

void exp1(int v1, int v2){
    cout << v1 << " " << v2 << endl;

    int temp = v1; 
    v1 = v2;
    v2 = temp;
    
    cout << v1 << " " << v2 << endl;
}

void exp2(int* r1, int* r2){
    cout << *r1 << " " << *r2 << endl;

    int temp = *r1; 
    *r1 = *r2;
    *r2 = temp;
    
    cout << *r1 << " " << *r2 << endl;
}

void exp3(int* p1, int* p2){
    cout << *p1 << " " << *p2 << endl;
    
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
    
    cout << *p1 << " " << *p2 << endl;
}

void exp4(int** p1, int** p2){
    cout << **p1 << " " << **p2 << endl;
    
    int* temp = *p1;
    *p1 = *p2;
    *p2 = temp;
    
    cout << **p1 << " " << **p2 << endl;
}

int main(int argc, char** argv){
    int v1 = 10;
    int v2 = 20;

    // val type, call by val
    // exp1(v1, v2);
    // cout << v1 << " " << v2 << endl;
    
    // val type, call by ref
    // exp2(&v1, &v2);
    // cout << v1 << " " << v2 << endl;
    
    int* r1 = &v1;
    int* r2 = &v2;
    
    // ref type, call by val
    // exp3(r1, r2);
    // cout << v1 << " " << v2 << endl;
    
    // ref type, call by ref
    exp4(&r1, &r2);
    // cout << v1 << " " << v2 << endl;
    
    cout << *r1 << " " << *r2 << endl;
    
    return 0;
}