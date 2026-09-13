# Multithreading Interview Prep (Expert, Simple)

## 1) Golden Rule
In every answer, talk in this order:
1. **Correctness** (is it safe?)
2. **Performance** (is it fast enough?)
3. **Trade-off** (what did you sacrifice?)

If you do this, you sound senior.

---

## 2) Must-Know Concepts (No Overthinking)

### `volatile`
- Gives **visibility** and **ordering**
- Does **not** make `count++` atomic

### `synchronized`
- Easy and safe lock
- Enter lock -> memory sync happens

### `ReentrantLock`
- Same job as `synchronized`, but more control:
  - `tryLock()`
  - interruptible lock
  - fairness option

### Atomics (`AtomicInteger`, etc.)
- Use CAS (compare and swap)
- Great for small shared counters/state

### Thread pool
- Reuse threads, avoid creating too many
- CPU tasks: thread count ~ cores
- IO tasks: can be higher than cores

### Concurrent collections
- `ConcurrentHashMap`, `BlockingQueue`
- Prefer these over manual locking when possible

### Deadlock prevention
- Keep lock order fixed
- Avoid nested locks if possible
- Use timeout lock where needed

---

## 3) Most Asked Interview Questions (Short Expert Answers)

1. **`volatile` vs `synchronized`?**  
`volatile` is only visibility/ordering. `synchronized` gives mutual exclusion + visibility.

2. **Why `notifyAll()` often better than `notify()`?**  
Safer when multiple waiter types exist; avoids waking wrong thread and stuck systems.

3. **How to make singleton thread-safe?**  
Use enum singleton, or double-check locking with `volatile`.

4. **How do you size a thread pool?**  
Based on task type (CPU vs IO), queue wait time, and rejection behavior.

5. **How do you avoid race conditions?**  
Minimize shared mutable state, use lock/atomic/concurrent collection, and define ownership clearly.

---

## 4) Coding Problems You Should Practice
1. Bounded blocking queue
2. Producer-consumer with graceful shutdown
3. Deadlock-free bank transfer
4. Thread-safe LRU cache
5. `CompletableFuture` fan-out/fan-in with timeout

---

## 5) Interview Red Flags
- “`volatile` makes code thread-safe”
- Ignoring `InterruptedException`
- Using unbounded queues under heavy load
- No explanation of memory visibility

---

## 6) 7-Day Smart Plan
1. **Day 1:** JMM + `volatile` + happens-before
2. **Day 2:** `synchronized`, `wait/notify`, `ReentrantLock`
3. **Day 3:** Atomics + CAS + race condition fixes
4. **Day 4:** ExecutorService + pool tuning
5. **Day 5:** Concurrent collections + coordination tools
6. **Day 6:** 3 coding problems under timer
7. **Day 7:** Full mock interview (theory + coding)

---

## 7) Last 20-Minute Revision
- `volatile` != atomic
- Locking is about correctness first
- Prefer simple safe design over clever unsafe optimization
- Always mention trade-off in your answer

---

## 8) Practice in Your Existing Project
Use these files:
- `src\main\java\com\job\ReentrantLock2.java`
- `src\main\java\com\job\ThreadA.java`
- `src\main\java\com\job\ThreadB.java`
- `src\main\java\com\job\ThreadC.java`
- `src\main\java\com\job\casestudy\Main2.java`

Mini exercises:
1. Add one race condition and fix it using `synchronized`
2. Fix same issue using atomics
3. Compare both designs (clarity + performance)
