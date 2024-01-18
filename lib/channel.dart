import 'package:flutter/services.dart';

class Channel {
  static const EventChannel _channel = EventChannel('toastResult');

  // Channel() {
  //   _channel = EventChannel('toastResult');
  // }

  static Stream<String> get toastClosingTime => _channel.receiveBroadcastStream().cast<String>();
}
