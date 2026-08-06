
# 🟢 Template 01 — Seen Elements (HashSet)

> **Category:** Arrays & Hashing

---

# 🎯 Recognition

Choose this template when the question asks:

- Detect duplicate elements.
- Check whether an element has been seen before.
- Maintain unique elements.
- Perform fast existence lookup.

---

# 🧠 Interview Thinking

```
Need to remember previous elements
                │
                ▼
Need fast existence lookup
                │
                ▼
          Use HashSet
```

---

# 💡 Core Idea

While traversing the array, keep track of every element you've already seen.

For each element:

- If it already exists in the set → Answer found.
- Otherwise, add it and continue.

---

# 📝 Java Template

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

# ⏱ Complexity

| Operation | Complexity |
|----------|------------|
| Lookup | O(1) |
| Insert | O(1) |
| Overall Time | O(n) |
| Space | O(n) |

---

# 🤔 Why HashSet?

Use **HashSet** when you only care about:

> **"Does this element already exist?"**

You don't need:

- Frequency
- Index
- Value Mapping

If extra information is required, HashMap is usually a better choice.

---

# ⚠️ Common Mistakes

❌ Using HashMap when only existence matters.

❌ Forgetting to add the current element after checking.

❌ Using nested loops (`O(n²)`) instead of hashing.

---

# 🔄 HashSet vs HashMap

| Need | Choose |
|------|--------|
| Only existence | ✅ HashSet |
| Frequency | ✅ HashMap |
| Value → Index | ✅ HashMap |
| Value → Count | ✅ HashMap |

---

# 📚 Problems Using This Template

- ✅ Contains Duplicate
- ⬜ Happy Number
- ⬜ Longest Consecutive Sequence
- ⬜ Unique Email Addresses
- ⬜ Find All Duplicates (Variation)

---

# 📝 Revision Checklist

Before using this template, ask yourself:

- [ ] Do I only need to know whether an element exists?
- [ ] Do I need fast lookup?
- [ ] Am I storing unnecessary information?

If all answers are **Yes**, use **HashSet**.

---

# ⭐ One Line Summary

> **Need fast existence lookup → Use HashSet.**
