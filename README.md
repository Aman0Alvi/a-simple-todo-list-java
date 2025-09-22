# A Simple To-Do List (Java)
<img width="346" height="455" alt="image" src="https://github.com/user-attachments/assets/fd7cfb9b-e8ff-464c-b3c6-93d0baaba109" />
<img width="306" height="185" alt="image" src="https://github.com/user-attachments/assets/9cd6d1ae-cb6b-4277-a375-431c16847c51" />

You can find the instructions for this lab [here](https://morethanequations.com/Computer-Science/Labs/A-Simple-To-Do-List). Create a new repository on GitHub to house your code. Be sure to make the repository public so that I can view and grade it.

We will use [Gradle](https://gradle.org/) to automate common development tasks.

## Building the App

You can build the app using:

```bash
./gradlew build
```

## Testing the App

You can run the automated suite of tests using:

```bash
./gradlew test
```

## Running the App

You can run the app using:

```bash
./gradlew run --quiet --console=plain
```

The two flags passed to the `run` command hide the noisy output from Gradle. You can see the details from Gradle by omitting those flags.
