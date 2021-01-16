package solution2021.design;

import tools.TreeNode;

class Trie {
    private class TrieNode{
        private boolean isEnd;
        private  TrieNode[] next;
        public TrieNode(){
            isEnd=false;
            next=new TrieNode[26];
        }

        
    }
    private TrieNode root;


    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur =root;
        for(int i=0,len =word.length(),ch;i<len;i++){
            ch=word.charAt(i)-'a';
            if(cur.next[ch]==null){
                cur.next[ch]=new TrieNode();

            }
            cur=cur.next[ch];
        }
        cur.isEnd=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur =root;
        for(int i=0,len =word.length(),ch;i<len;i++){
            ch=word.charAt(i)-'a';
            if(cur.next[ch]==null) return false;
            cur=cur.next[ch];
        }

        return cur.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0, len = prefix.length(), ch; i < len; i++) {
            ch = prefix.charAt(i) - 'a';
            if (cur.next[ch] == null)
                return false; // 若还没遍历完给定的前缀子串，则直接返回false
            cur = cur.next[ch];
        }
        return true; // 直接返回true

    }
}
