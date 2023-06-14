# Test Mobile Apps with Appium
Materi hari 20 kelas SQA batch 9 Juara Coding

## Perintah - perintah yang sering digunakan (untuk emulator)
* untuk melihat package

`adb shell pm list packages`

* untuk melihat activity

`adb shell dumpsys activity activities | grep "mFocused"`

* untuk reboot device

`adb shell am broadcast -a android.intent.action.BOOT_COMPLETED`

* untuk shutdown device

`adb shell reboot -p`

* untuk restart adb

`adb kill-server`

`adb start-server`

* untuk mengetahui activity yang pertama kali dibuka oleh aplikasi dan mengakibatkan appium tidak dapat terhubung ke emulator

`adb shell "cmd package resolve-activity --brief appPackage | tail -n 1"`
