//baekjoon ps 10830

#include <iostream>
#include <vector>
#include <map>

using namespace std;
typedef vector<vector<unsigned long long>> matrix;
constexpr unsigned long long M = 1000;
unsigned long long n, b;

matrix multiply(const matrix &A, const matrix &B)
{
    matrix res(n, vector<unsigned long long>(n, 0));
    for (unsigned long long i = 0; i < n; i++)
        for (unsigned long long j = 0; j < n; j++)
            for (unsigned long long x = 0; x < n; x++)
            {
                res[i][j] += (A[i][x] % M * B[x][j] % M) % M;
                res[i][j] %= M;
            }
    return res;
}

matrix bfs(matrix A, unsigned long long exp)
{
    matrix res(n, vector<unsigned long long>(n, 0));
    for (int i = 0; i < n; i++)
        res[i][i] = 1;
    while (exp)
    {
        if (exp % 2 == 1)
            res = multiply(res, A);
        exp /= 2;
        A = multiply(A, A);
    }
    return res;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin >> n >> b;
    matrix A(n, vector<unsigned long long>(n));
    for (unsigned long long i = 0; i < n; i++)
        for (unsigned long long j = 0; j < n; j++)
            cin >> A[i][j];
    auto res = bfs(A, b);
    for (unsigned long long i = 0; i < n; i++)
    {
        for (unsigned long long j = 0; j < n; j++)
            cout << res[i][j] << " ";
        cout << '\n';
    }
    return 0;
}