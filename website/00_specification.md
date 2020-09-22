Wesbite
=======

```
Responsible Persons:
Implementation and html structure: ---insert your name---
Design (CSS): --insert your name---
If same person please complete Implementation beforehand.
```

Should support the following functionality:

* Discord Link
* Embed YouTube stream
* Embed stream schedule
* Embed Chat
* WebPush for stream notifications

Please specify properties that have special handling in the CalDav claendar.
Bonus points if seamlessly managable as Google Calendar.

Discord Link
============

Provide easy access to Discord server at all time. User might have kicked them
self out of the server at any time. Provide them with the ability to recover.

Embed YouTube stream
====================

Needs non static server backend.

Shall be visible prominantly when stream is running. Might need to fiddle with
YouTube APIs and special access to google account. The streams are all set to
non-public, link only visible. Provide easy and prominent abillity to go to
YouTube page (means app on mobile). The website is not the primary place to
view the stream. React on stream state change without page reload.

Embed stream schedule
=====================

Allow display of a CalDav calendar source. Display the current week. Allow to
view the other week.

Embed Chat
==========

Probably a Discord widget. Display only when stream is active. Do not unload
automatically when stream ends. Only load when stream becomes active.
Stream might become active without page reload.

WebPush for stream notifications
================================

Needs non static server backend.

Allow user to register for push notifications from website. We will use this
to send notifications when a stream starts. WebPush is supported on Firefox,
Safari, Chrome, whatnot. Also supports desktop and mobile alike. Set open link
to YouTube page (So that app opens on mobile), not our website. Allow for
unregister. Send notifications automatically when YoutTube stream starts.
Allow user to set reminder when stream is scheduled (User selects category and
time delta). Use CalDav as schedule source.