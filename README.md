# CIS656-Lab2-part1

Modify the client program (ComputePi.java) so that it goes in a loop and prompts the
user (from standard input) to select a task, 1) Compute Pi, 2) Compute Primes, 3) Exit. If
the user selects (1) the user is prompted to enter the number places Pi is to be computed
to and the task sent to the server via RMI. The results are printed to standard output upon

return. If the user selects (2) the user enters a min and a max, and the task sent to the
server via RMI. The results are printed to the standard output upon return. If the user
selects (3) the client program will exit.

## How to build
Run the following scripts

```bash
bash shared_jar_creation.bash <shared_folder_location>
bash compile_engine.bash <shared_folder_location>
bash compile_client.bash <shared_folder_location>
```

## How to run
Modify your ```.security``` files to match the absolute path to src folder in this repo

For example:

```json
grant codeBase "file:<path_to_repo>/src/" {
    permission java.security.AllPermission;
};
```

Then run the following scripts in one terminal:

```bash
bash run_rmiregistry.bash
bash run_engine.bash <absolute path to src> <shared_folder_location> <url_to_shared_codebase> <rmi_hostname>
```

And in another terminal run:

```bash
bash run_client.bash <absolute path to src> <shared_folder_location> <url_to_shared_codebase> <rmi_hostname>
```
