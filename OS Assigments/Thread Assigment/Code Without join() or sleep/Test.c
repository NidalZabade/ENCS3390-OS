#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int evenCount = 0;
int oddCount = 0;
int evenArray[10];
int oddArray[10];
int mergeArray[10];
int flag[] = {1, 1};

void even()
{
    for (int i = 0; i < 10; i++)
    {
        if (array[i] % 2 == 0)
        {
            evenArray[evenCount] = array[i];
            evenCount++;
        }
    }
    flag[0] = 0;
}
void odd()
{
    for (int i = 0; i < 10; i++)
    {
        if (array[i] % 2 != 0)
        {
            oddArray[oddCount] = array[i];
            oddCount++;
        }
    }
    flag[1] = 0;
}

void merge()
{

    for (int i = 0; i < evenCount; i++)
    {
        mergeArray[i] = evenArray[i];
    }
    for (int i = 0; i < oddCount; i++)
    {
        mergeArray[i + evenCount] = oddArray[i];
    }
}

int main()
{

    pthread_t thread1, thread2, thread3;

    pthread_create(&thread1, NULL, (void *)even, NULL);
    pthread_create(&thread2, NULL, (void *)odd, NULL);
    while (flag[0] || flag[1]);
    pthread_create(&thread3, NULL, (void *)merge, NULL);

    printf("Even Array: ");
    for (int i = 0; i < 10; i++)
    {
        printf("%d ", evenArray[i]);
    }
    printf("\n");
    printf("Odd Array: ");
    for (int i = 0; i < 10; i++)
    {
        printf("%d ", oddArray[i]);
    }
    printf("\n");
    printf("Merge Array: ");
    for (int i = 0; i < 10; i++)
    {
        printf("%d ", mergeArray[i]);
    }

    return 0;
}
