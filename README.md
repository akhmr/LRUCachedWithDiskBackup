# LRUCachedWithDiskBackup 
This cache is  written in using concurent haspmap and  doubly linked list.

Assumtion:
1) All key are considered as int.
2) Value is store in queue and in file disk in byte array format
3) Disk back up has two options either 1) Sync(will be slow ) 2) Async
