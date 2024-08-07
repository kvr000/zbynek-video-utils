# Zbynek Video Utilitilies - zbynek-video-tool command line utility

Command line utility to manipulate video files.


## Download

- https://github.com/kvr000/zbynek-video-utils/releases/download/master/zbynek-video-tool
- https://github.com/kvr000/zbynek-video-utils/releases/tag/master


## Usage

```
usage: zbynek-video-tool [-h] [--vi VIDEO_INPUT] [--vo VIDEO_OUTPUT] ...

Subtitles operations

positional arguments:
  subcommand

options:
  -h, --help            show this help message and exit
  --vi VIDEO_INPUT, --video-input VIDEO_INPUT
  --vo VIDEO_OUTPUT, --video-output VIDEO_OUTPUT
```

#### Options


### convert

```
usage: zbynek-video-tool convert [-h] [--default-audio default audio track language, empty for none] [--default-subtitle default subtitle track language, empty for none]

Sets default streams

options:
  -h, --help            show this help message and exit
  --default-audio default audio track language, empty for none
  --default-subtitle default subtitle track language, empty for none
```

Converts video stream, possibly changing default tracks.

#### Options

- `-default-audio language` : default audio track
- `-default-subtitle language` : default subtitle track


### concat

```
usage: /home/rat/bin/zbynek-video-tool concat [-h] inputs [inputs ...]

Concatenates files

positional arguments:
  inputs

options:
  -h, --help  show this help message and exit
```

Concats video streams.

#### Options

- `-default-audio language` : default audio track
- `-default-subtitle language` : default subtitle track


### subtitle-embed

```
usage: zbynek-video-tool subtitle-embed [-h] [--prio language priorities, comma separated or multiple arguments]

Embed subtitles

options:
  -h, --help            show this help message and exit
  --prio language priorities, comma separated or multiple arguments
```

The command adds subtitles from the-video.*.srt into the the-video file.

#### Options


### subtitle-convert

```
usage: zbynek-video-tool subtitle-convert [-h] [-i [INPUTS]] [-o [OUTPUT]] [-t TYPE] [--delay [DELAY]] inputs [inputs ...]

Convert subtitles

positional arguments:
  inputs

options:
  -h, --help            show this help message and exit
  -i [INPUTS], --input [INPUTS]
  -o [OUTPUT], --output [OUTPUT]
  -t TYPE, --type TYPE
  --delay time:delay    delays subtitle at time by delay seconds (can be negative and specified twice to proportionally delay)              
```

The command converts subtitles files across various formats (srt and sub are supported).


### General Options

- `-h, --help` : show this help message and exit
- `--vi VIDEO_INPUT, --video-input` : VIDEO_INPUT
- `--vo VIDEO_OUTPUT, --video-output` : VIDEO_OUTPUT


## Build

You need to install:
- python3
- ffmpeg
- ffprobe

Debian or Ubuntu:
```
sudo apt -y install python3 ffmpeg
```

RedHat or Suse:
```
sudo yum -y install python3 ffmpeg
```

MacOs:
```
brew install python3 ffmpeg
```

Build:
```
git clone https://github.com/kvr000/zbynek-video-utils.git
cd zbynek-video-utils/

./zbynek-video-tool/src/main/python/zbynek-video-tool -h
```


## License

The code is released under version 2.0 of the [Apache License][].

## Stay in Touch

Author: Zbynek Vyskovsky

Feel free to contact me at kvr000@gmail.com  and http://github.com/kvr000/ and http://github.com/kvr000/zbynek-video-utils/

LinkedIn: https://www.linkedin.com/in/zbynek-vyskovsky/


[Apache License]: http://www.apache.org/licenses/LICENSE-2.0
