# 🟢 Template 04 — Prefix Sum + Frequency HashMap

> **Category:** Arrays & Hashing

---

## 🎯 Recognition

Use this template when you need to:

- Find/count **subarrays with a target sum**.
- Work with cumulative/running sums.
- Handle **negative numbers**, where sliding window doesn't reliably work.
- Find how many previous prefixes can form the required sum.

---

## 🧠 Interview Thinking

Need to find/count a subarray with sum K
                │
                ▼
Use Prefix Sum
                │
                ▼
Current Sum - Previous Sum = K
                │
                ▼
Previous Sum = Current Sum - K
                │
                ▼
Need fast lookup + frequency
                │
                ▼
HashMap


---

## 💡 Core Idea

While traversing the array:

1. Maintain the current `prefixSum`.
2. Calculate the required previous prefix:

required = prefixSum - k

3. Check how many times `required` has appeared.
4. Add that frequency to the answer.
5. Store the current `prefixSum` in the map.

The map stores:

Prefix Sum → Frequency


---

## 📝 Java Template

Map<Integer, Integer> prefixCount = new HashMap<>();

// Empty prefix
prefixCount.put(0, 1);

int prefixSum = 0;
int result = 0;

for (int num : nums) {

    prefixSum += num;

    int required = prefixSum - k;

    result += prefixCount.getOrDefault(required, 0);

    prefixCount.put(
        prefixSum,
        prefixCount.getOrDefault(prefixSum, 0) + 1
    );
}


---

## ⏱ Complexity

| Time | Space |
| ---- | ----- |
| O(n) | O(n)  |


---

## 🤔 Why HashMap?

We need to know:

How many times has a particular prefix sum appeared before?

So we store:

Prefix Sum → Frequency

HashMap gives us average O(1) lookup.


---

## ⚠️ Common Mistakes

- Forgetting:

prefixCount.put(0, 1);

- Storing the current prefix **before** checking `prefixSum - k`.
- Using `HashSet` instead of `HashMap` — we need the **frequency**, not just existence.
- Thinking this only works with positive numbers. It also handles **negative numbers and zeros**.


---

## 📚 Used In

- ✅ Subarray Sum Equals K
- Future subarray/range-sum problems where a **target sum + prefix frequency** is required.


---

## ⭐ One-Line Summary

> **Need to count subarrays with sum K → Prefix Sum + Frequency HashMap.**
