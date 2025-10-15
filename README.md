# FilePacker_UnPacker
# Overview
This project contains two Java programs:
Packer.java → Combines multiple files from a folder into one single file.
Unpacker.java → Extracts those files back from the packed file.
It works like a simple ZIP and UNZIP utility.

# Files
Packer.java
Unpacker.java
ExampleFolder/   ← Folder to pack
PackedFile.pak   ← Output file

# How It Works
Packer.java
Takes folder name and packed file name as input.
Reads all files from the folder.
Creates one output file (e.g., DmoFile.txt).
For each file:
Writes a 100-byte header (file name + size).
Writes the file data.
Shows total files packed.

Unpacker.java
Takes packed file name as input.
Reads 100 bytes (header) to get file name and size.
Reads file data and writes it into a new file.
Repeats for all files and shows total files unpacked.

Author

Gaurav Subhash Kumbhar
