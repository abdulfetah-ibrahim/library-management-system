# Library Management (setp project)

A simple Java project that manages books in memory and persists them to a text file using a repository-style class ('Library') and a model ('Book').

---

## Git Usage

We used Git to track changes, collaborate safely, and keep a clean history.

* **Initialize repository**

  * 'git init' — created a new local Git repository for the project.

* **Stage changes**

  * 'git add .' — staged all new and modified files (models, repositories, README).

* **Commit changes**

  * 'git commit -m "feat(repo): add Library class"' — saved logical checkpoints with clear messages.

* **Push to remote**

  * 'git push origin main' — uploaded local commits to the remote repository.

* **Pull updates**

  * 'git pull' — synced local code with remote changes before continuing work.

* **Work with branches**

  * 'git checkout -b feat/library'
  * 'git checkout feat/library' — Switched to the existing feature branch to continue isolated work.

---

## Branching & Merging Flow

We followed a simple and safe branching strategy:

1. **Main branch ('main')**

   * Contains completed and reviewed features.

2. **Feature branches**

   * Created a branch for each change (e.g., repositories, models, file sync).
   * Example: 'feat/library', 'feat/book', 'fix/book'

3. **Development flow**

   * Implement changes and commit incrementally on the feature branch.
   * Keep commits small and focused.

4. **Merge back to main**

   * Switch to main: 'git checkout main'
   * Merge: 'git merge feat/library'

This flow keeps 'main' stable, makes changes easy to review, and reduces the risk of breaking the application.
