2. Inisialisasi Git di Eclipse
Jika project Anda belum terhubung ke Git:

Klik kanan pada nama project di Package Explorer.

Pilih Team > Share Project...

Pilih Git dan klik Next.

Centang "Use or create repository in parent folder of project", klik pada project Anda, lalu klik Create Repository.

Klik Finish.

3. Commit Perubahan
Sekarang Anda perlu memberi tahu Git file mana saja yang ingin disimpan:

Klik kanan pada project > Team > Add to Index (ini akan menyiapkan file untuk di-commit).

Klik kanan lagi > Team > Commit...

Jendela Git Staging akan muncul.

Pastikan file ada di kolom Staged Changes.

Tulis pesan commit di kotak Commit Message (misal: "Initial commit").

Klik tombol Commit (jangan klik Commit and Push dulu agar kita bisa mengatur remote-nya dengan benar).

4. Push ke GitHub
Langkah terakhir adalah mengirim file ke server GitHub:

Klik kanan project > Team > Remote > Push...

Di kolom URI, tempelkan (paste) URL GitHub yang Anda salin tadi.

Masukkan Username dan Personal Access Token (PAT) GitHub Anda di bagian Authentication.

Catatan: GitHub sudah tidak menerima password akun biasa untuk push. Anda harus menggunakan Token.

Klik Next.

Pada bagian Source ref, pilih master atau main. Klik Add Spec.

Centang kotak Force update jika diperlukan (biasanya tidak perlu untuk project baru).

Klik Finish.
