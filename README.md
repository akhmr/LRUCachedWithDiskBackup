# LRUCachedWithDiskBackup 
This cache is  written in using concurent haspmap and  doubly linked list.

Assumtion:
1) All key are considered as int.
2) Value is store in queue and in file disk in byte array format
3) Disk back up has two options either 1) Sync(will be slow ) 2) Async

Feature in the process to be implemented.
1)After jvm or system restart queue need to be backed up from the disked data.
2) Test cases for testing the data
3) Perfromance test case between Async and Sync model
