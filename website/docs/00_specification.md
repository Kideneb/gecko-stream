Wesbite
=======

```
Responsible Persons:
Implementation and html structure: ---insert your name---
Design (CSS): --insert your name---
If same person please complete Implementation beforehand.
```

Discord Link
============

Provide easy access to Discord server at all time. User might have kicked them
self out of the server at any time. Provide them with the ability to recover.

Embed YouTube stream
====================

Needs non static server backend.

YouTube does not allow embed. There is no link to a livestream valid for all
events of a channel. Create YouTube stream event beforehand based on Google
calendar. Set the link to the current valid event on the website based on the
next upcoming event.


Embed stream schedule
=====================

Allow display of a CalDav calendar source. Display the current week. Allow to
view the other week.

Probably easier to transform the Google calendar into a simple json file at
a know location. Apply filtering at this step. Then use a javascript claendar
widget to display everything.

Embed Chat
==========

Do not use the Discord widget. Link to an invite which does not need a Discord
account. Link to #chat not #welcome.

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

Discord for notifications
=========================

Send messages via webhook when time reached for upcoming event.