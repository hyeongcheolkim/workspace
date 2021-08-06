//baekjoon ps 11066

#include <iostream>
#include <vector>
#include <limits>
#include <algorithm>

using namespace std;

constexpr int INF = numeric_limits<int>::max();
vector<int> arr, sum;
vector<vector<int>> dp;

int dfs(int lt, int rt)
{
    static auto subtotal = [&](int begin, int end)
    { return sum[end] - sum[begin - 1]; };
    
    int &ret = dp[lt][rt];
    if (ret != INF)
        return ret;
    if (lt == rt)
        return ret = 0;
    if (lt + 1 == rt)
        return ret = arr[lt] + arr[rt];
    for (int k = lt; k < rt; k++)
        ret = min(ret, dfs(lt, k) + dfs(k + 1, rt));
    return ret += subtotal(lt, rt);
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
    while (t--)
    {
        int k;
        cin >> k;
        sum = move(vector<int>(k + 1));
        arr = move(vector<int>(k + 1));
        dp = move(vector<vector<int>>(k + 1, vector<int>(k + 1, INF)));
        for (int i = 1; i <= k; i++)
        {
            cin >> arr[i];
            sum[i] = sum[i - 1] + arr[i];
        }
        cout << dfs(1, k) << '\n';
    }
    return 0;
}