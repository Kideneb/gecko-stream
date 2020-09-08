Google WebRTC Filter
====================

We use an own fork of a pulseaudio plugin that wraps Googles WebRTC audio
processing framework.

> APM is the audio processing module of WebRTC project in charge of effects like
> echo cancellation, noise suppression, etc. The purpose of this project is to
> build a standalone library for Chrome OS system side audio processing.

[Google repo][1]

Features
--------

Taken from [this][2] site. Not saying how easy it is to include them in the
pulseaudio module.

* High Pass filter
* Echo cancel
* Mobile echo controller
* Residual echo detector
* Noise suppressor
* Adaptive gain controller
* Gain controller 2
* Pre amplifier
* Echo controller
* Voice activity detector
* Private voice detector
* Level estimator
* Transient suppressor


[1]: https://chromium.googlesource.com/chromiumos/third_party/webrtc-apm/
[2]: https://chromium.googlesource.com/chromiumos/third_party/webrtc-apm/+/refs/heads/master/modules/audio_processing/audio_processing_impl.h