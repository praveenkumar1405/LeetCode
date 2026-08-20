#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

struct TrieNode {
    TrieNode* children[2];
    TrieNode() {
        children[0] = children[1] = nullptr;
    }
};

class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        if (nums.empty()) return 0;
        
        TrieNode* root = new TrieNode();
        
        // Insert all numbers into the Trie
        for (int num : nums) {
            TrieNode* node = root;
            for (int i = 31; i >= 0; --i) {
                int bit = (num >> i) & 1;
                if (!node->children[bit]) {
                    node->children[bit] = new TrieNode();
                }
                node = node->children[bit];
            }
        }
        
        int max_xor = 0;
        
        // Query maximum XOR for each number
        for (int num : nums) {
            TrieNode* node = root;
            int curr_xor = 0;
            for (int i = 31; i >= 0; --i) {
                int bit = (num >> i) & 1;
                int toggle = 1 - bit;
                
                if (node->children[toggle]) {
                    curr_xor |= (1 << i);
                    node = node->children[toggle];
                } else {
                    node = node->children[bit];
                }
            }
            max_xor = max(max_xor, curr_xor);
        }
        
        // Optional: Add memory cleanup here for production code
        return max_xor;
    }
};   