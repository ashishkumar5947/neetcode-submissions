# 🟢 Template 02 — Frequency Counting

> **Category:** Arrays & Hashing

---

## 🎯 Recognition

Use this template when you need to:

- Count occurrences of elements.
- Compare frequencies.
- Check if two collections contain the same elements with the same count.
- Track character or element frequency.

---

## 🧠 Interview Thinking

```text
Need to know how many times each element appears
                    │
                    ▼
             Store Frequency
                    │
        ┌───────────┴───────────┐
        ▼                       ▼
 General Elements        Fixed Character Set
        │                       │
        ▼                       ▼
     HashMap              Frequency Array
```

---

## 💡 Core Idea

Traverse the input and maintain the frequency of each element.

Increase the frequency when processing the first input.

Decrease the frequency when processing the second input.

If any frequency becomes negative, the answer is immediately false.

---

## 📝 Java Template (HashMap)

```java
Map<Character, Integer> frequency = new HashMap<>();

for (char c : first.toCharArray()) {
    frequency.put(c, frequency.getOrDefault(c, 0) + 1);
}

for (char c : second.toCharArray()) {

    if (!frequency.containsKey(c))
        return false;

    frequency.put(c, frequency.get(c) - 1);

    if (frequency.get(c) < 0)
        return false;
}
```

---

## 📝 Java Template (Frequency Array)

> Use only when the character set is fixed (e.g. lowercase English letters).

```java
int[] frequency = new int[26];

for (char c : first.toCharArray()) {
    frequency[c - 'a']++;
}

for (char c : second.toCharArray()) {

    frequency[c - 'a']--;

    if (frequency[c - 'a'] < 0)
        return false;
}
```

---

## ⏱ Complexity

### HashMap

| Time | Space |
|------|-------|
| O(n) | O(n) |

### Frequency Array

| Time | Space |
|------|-------|
| O(n) | O(1) |

---

## 🤔 HashMap or Frequency Array?

### ✅ Use HashMap when

- Elements can be anything.
- Character set is unknown.
- Unicode is allowed.
- General-purpose solution is required.

### ✅ Use Frequency Array when

- Character set is fixed.
- Only lowercase letters.
- Only uppercase letters.
- Digits (0–9).
- ASCII characters.

---

## ⚠️ Common Mistakes

- Forgetting the initial length check.
- Using a HashMap when a fixed-size array is sufficient.
- Not returning false when frequency becomes negative.

---

## 📚 Used In

- ✅ Valid Anagram
- Group Anagrams
- Find All Anagrams in a String
- Permutation in String
- Ransom Note
- Determine if Two Strings Are Close
- Find Common Characters

---

## ⭐ One-Line Summary

> **Need to compare counts → Use Frequency Counting.**
