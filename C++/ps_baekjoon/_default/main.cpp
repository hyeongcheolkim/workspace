#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    int n;
    cin >> n;
    vector<int> lis;
    lis.push_back(0);
    for (int i = 0; i < n; ++i)
    {
        int num;
        cin >> num;
        if (lis.back() < num)
            lis.push_back(num);
        else
            *lower_bound(lis.begin(), lis.end(), num) = num;
    }
    cout << n - (lis.size() - 1);
    return 0;
}