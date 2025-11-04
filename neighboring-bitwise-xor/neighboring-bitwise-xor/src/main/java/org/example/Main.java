package org.example;


/**
 * https://leetcode.com/problems/neighboring-bitwise-xor/description/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     *
     * x ⊕ x = 0
     * x ⊕ 0 = x
     * ( a0⊕a1 ) ⊕ ( a1⊕a2 ) ⊕ ( a2⊕a3 ) ⊕ ... ⊕ ( a{n-2}⊕a{n-1} ) ⊕ ( a{n-1}⊕a0 )
     *
     * @param derived
     * @return
     */


    /**
     * LeetCode 2683 — Neighboring Bitwise XOR
     *
     * Problem:
     *  You're given a binary array `derived` of length n, where
     *  derived[i] = original[i] XOR original[(i+1) mod n].
     *  Determine if there exists a binary array `original` that produces `derived`.
     *
     * Key fact (necessary & sufficient):
     *  XOR over all derived elements must be 0.
     *
     *
     * remind: x ⊕ x = 0 and x ⊕ 0 = x
     * we can do the following
     * ( a0⊕a1 ) ⊕ ( a1⊕a2 ) ⊕ ( a2⊕a3 ) ⊕ ... ⊕ ( a{n-2}⊕a{n-1} ) ⊕ ( a{n-1}⊕a0 )
     *
     * so the idea is if xor of derived === 0 then we have original array;
     *
     *  Proof sketch:
     *   Expand the total XOR:
     *     (a0^a1) ^ (a1^a2) ^ ... ^ (a{n-1}^a0)
     *   Using associativity/commutativity and x^x=0, every ai appears exactly twice,
     *   so the total cancels to 0. Therefore any valid `derived` must have XOR = 0.
     *   Conversely, if XOR(derived)=0, pick original[0] arbitrarily (0 or 1) and
     *   reconstruct forward:
     *     original[i+1] = original[i] ^ derived[i]  for i=0..n-1,
     *   The closure original[n] == original[0] holds exactly when XOR(derived)=0,
     *   so a solution exists.
     *
     * Algorithm (two equivalent views):
     *  A) O(n) / O(1):
     *     - Compute s = XOR of all derived[i].
     *     - Return (s == 0).
     *  B) Reconstruction check (didactic):
     *     - Choose o0 = 0, reconstruct original[i+1] = original[i] ^ derived[i].
     *     - Check original[n] == o0. This is equivalent to A).
     *
     * Complexity:
     *  - Time:  O(n)
     *  - Space: O(1)
     *
     * Edge cases:
     *  - n=1: derived[0] must be 0 (since a0^a0=0). Our check s==0 handles this.
     *  - Any non-binary values would violate problem constraints (assumed 0/1).
     *
     * Example:
     *  derived = [1,0,1]  → XOR= (1^0^1)=0 → true
     *  derived = [1,1,1]  → XOR=1 → false
     *
     * @param derived binary array where derived[i] = original[i] ^ original[(i+1) mod n]
     * @return true if a valid original array exists, false otherwise
     */
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int i = 0; i < derived.length; i++) {
            xor ^= derived[i];
        }
        return xor == 0;
    }
}