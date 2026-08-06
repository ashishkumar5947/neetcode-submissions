# 🟢 Template 01 — Seen Elements (HashSet)

> **Category:** Arrays & Hashing

---

## 🎯 Recognition

Use this template when you need to:

- Detect duplicate elements.
- Check whether an element has been seen before.
- Maintain unique elements.
- Perform fast existence lookup.

---

## 🧠 Interview Thinking

```text
Need to remember previous elements
            │
            ▼
Need fast existence lookup
            │
            ▼
       Use HashSet
```

---

## 💡 Core Idea

Traverse the array while storing every visited element.

- If the current element already exists → **Answer found**
- Otherwise, add it and continue.

---

## 📝 Java Template

```java
Set<Integer> seen = new HashSet<>();

for (int num : nums) {

    if (seen.contains(num)) {
        // Answer found
    }

    seen.add(num);
}
```

---

## ⏱ Complexity

| Time | Space |
|------|-------|
| O(n) | O(n) |

---

## 🤔 Why HashSet?

Use **HashSet** when you only need to know:

> **"Have I seen this element before?"**

No extra information is required.

If you need additional information like:

- Frequency
- Index
- Mapping

then **HashMap** is a better choice.

---

## ⚠️ Common Mistakes

- Using `HashMap` when only existence is required.
- Forgetting to add the current element after checking.
- Using nested loops instead of hashing.

---

## 🔄 HashSet vs HashMap

| Need | Data Structure |
|------|----------------|
| Only existence | ✅ HashSet |
| Frequency Count | ✅ HashMap |
| Value → Index | ✅ HashMap |
| Value → Count | ✅ HashMap |

---

## 📚 Used In

- ✅ Contains Duplicate
- Happy Number
- Longest Consecutive Sequence
- Unique Email Addresses
- Check If N and Its Double Exist
- Find All Duplicates in an Array
- Find the Difference of Two Arrays

---

## ⭐ One-Line Summary

> **Need to know "Have I seen this before?" → Use HashSet.**
