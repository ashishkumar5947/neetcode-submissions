# 🟢 Template 03 — Value → Index Mapping

> **Category:** Arrays & Hashing

---

## 🎯 Recognition

Use this template when you need to:

- Find a previously seen element.
- Return the index (or any associated information) instead of just the value.
- Perform fast lookup while preserving extra information.

---

## 🧠 Interview Thinking

```text
Need to find a previous element
                │
                ▼
Need associated information
                │
                ▼
Store

Value  →  Information
```

For Two Sum:

```text
Number → Index
```

---

## 💡 Core Idea

While traversing the array:

1. Compute the information you need.
2. Check whether it already exists.
3. If found, return the stored information.
4. Otherwise, store the current element and continue.

---

## 📝 Java Template

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {

    int key = ...;

    if (map.containsKey(key)) {
        // Answer found
    }

    map.put(currentValue, associatedInformation);
}
```

---

## ⏱ Complexity

| Time | Space |
|------|-------|
| O(n) | O(n) |

---

## 🤔 Why HashMap?

Use **HashMap** when you need:

- Fast lookup (`O(1)` average).
- To retrieve associated information.
- More than just existence.

Unlike `HashSet`, a `HashMap` stores both:

```text
Key → Value
```

---

## ⚠️ Common Mistakes

- Inserting before checking (may use the same element twice).
- Storing the wrong key/value pair.
- Using `HashSet` when associated information is required.

---

## 📚 Used In

- ✅ Two Sum
- Isomorphic Strings
- Word Pattern
- Copy List with Random Pointer
- Find Duplicate File in System
- Time Based Key-Value Store

---

## ⭐ One-Line Summary

> **Need fast lookup with associated information → Use HashMap (Value → Information).**
