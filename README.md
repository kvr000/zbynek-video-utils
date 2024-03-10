# Zbynek Video Utilitilies - zbynek-video-util command line utility

Command line utility to manipulate video files.


## Usage

```
usage: zbynek-video-util [-h] [--vi VIDEO_INPUT] [--vo VIDEO_OUTPUT] ...

Subtitles operations

positional arguments:
  subcommand

options:
  -h, --help            show this help message and exit
  --vi VIDEO_INPUT, --video-input VIDEO_INPUT
  --vo VIDEO_OUTPUT, --video-output VIDEO_OUTPUT
```


### embed

```
usage: zbynek-video-util embed [-h] [--prio language priorities, comma separated or multiple arguments]

Embed subtitles

options:
  -h, --help            show this help message and exit
  --prio language priorities, comma separated or multiple arguments
```

The command adds subtitles from the-video.*.srt into the the-video file.

#### Options


### convert

```
usage: zbynek-video-util convert [-h] [-i [INPUTS]] [-o [OUTPUT]] [-t TYPE] [--delay [DELAY]] inputs [inputs ...]

Convert subtitles

positional arguments:
  inputs

options:
  -h, --help            show this help message and exit
  -i [INPUTS], --input [INPUTS]
  -o [OUTPUT], --output [OUTPUT]
  -t TYPE, --type TYPE
```

The command converts subtitles files across various formats (srt and sub are supported).


### General Options

- `-h, --help` : show this help message and exit
- `--vi VIDEO_INPUT, --video-input` : VIDEO_INPUT
- `--vo VIDEO_OUTPUT, --video-output` : VIDEO_OUTPUT


## Build

You need to install:
- python
- ffmpeg
- ffprobe

Debian or Ubuntu:
```
sudo apt -y install ffmpeg python3
```

MacOs:
```
brew install ffmpeg python3
```

RedHat or Suse:
```
sudo yum -y install ffmpeg python3
```

Build:
```
git clone https://github.com/kvr000/zbynek-video-utils.git
cd zbynek-video-utils/

./zbynek-video-util/src/main/python/zbynek-video-util -h
```


## License

The code is released under version 2.0 of the [Apache License][].

## Stay in Touch

Feel free to contact me at kvr000@gmail.com  and http://github.com/kvr000/ and http://github.com/kvr000/zbynek-legal-util/

LinkedIn: https://www.linkedin.com/in/zbynek-vyskovsky/


[Apache License]: http://www.apache.org/licenses/LICENSE-2.0
