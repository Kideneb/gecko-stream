Audio Infrastructure
====================

The audio pipeline is responsible for collecting audio streams, processing them
and finally feeding audio samples to OBS. Processing includes muxing multiple
streams and applying effects and filters on them at different stages. The
pipeline lives inside [Pulseaudio][1].

A typical example of the pipeline looks like this:

```
                      Control commands, status report
              +-------------------------------------------+
              |                                           |
    +-----+   |           +-----+                         |
    |Mic A+<--+           |Mic A+<------------------------+
    +--+--+               +--+--+                         |
       |                     |         +-----------+      |
       |                     |         |Loudspeaker|      |
       |                     |         +-+---------+      |
       |                     |           ^                |
+--------------------------------------------------------------------+
|      |                     |           |                |          |
|      v                     v           |                |          |
| +----+-----+          +----+-----+     |                |          |
| |roc-recv  |          |roc-recv  |     |                |          |
| |Instance A|          |Instance B|     +----+           |          |
| +----+-----+          +---+------+     |    |           v          |
|      |                    |            |    |  +--------+-------+  |
|      |                    |            |    |  |gecko_audio_ctrl|  |
|      |                    |      +-----+-+  |  +----------------+  |
|      v                    |      |Discord|  |                      |
|  +---+---------------+    |      +-----+-+  |                      |
|  |Webrtc Filter      |    |            |    |                      |
|  |Echo-cancel, etc...+<---------------------+ Feedback-loop        |
|  +---+---------------+    |            |    | To remove samples    |
|      |                    v            |    | played by Loudspeaker|
|      |   +----------------+--+         |    | picked up by Mics    |
|      |   |Webrtc Filter      |         |    |                      |
|      |   |Echo-cancel, etc...+<-------------+                      |
|      |   +--+----------------+         |                           |
|      |      |                          |                           |
|      |      v      +---------+         v                 +------+  |
|      +------+----->+Equalizer+-------->+---------------->+OBS In|  |
|                    +---------+                           +------+  |
|Streaming  PC                                                       |
+--------------------------------------------------------------------+
```

Resources
---------

### WebRTC APM

> APM is the audio processing module of WebRTC project in charge of effects like
> echo cancellation, noise suppression, etc. The purpose of this project is to
> build a standalone library for Chrome OS system side audio processing.

[Google repo][2]

[1]: https://www.freedesktop.org/wiki/Software/PulseAudio/About/
[2]: https://chromium.googlesource.com/chromiumos/third_party/webrtc-apm/