package evbattery.system;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_NAME = "data_sistem_baterai.json";

    // 1. MEMBUAT ADAPTER KHUSUS UNTUK CLASS ABSTRACT 'BATERAI'
    private static class BateraiAdapter implements JsonSerializer<Baterai>, JsonDeserializer<Baterai> {
        
        // Saat Menyimpan (Save): Tambahkan label "TIPE_CLASS" ke dalam JSON
        @Override
        public JsonElement serialize(Baterai src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonObject = context.serialize(src, src.getClass()).getAsJsonObject();
            jsonObject.addProperty("TIPE_CLASS", src.getClass().getSimpleName());
            return jsonObject;
        }

        // Saat Membaca (Load): Baca label "TIPE_CLASS" untuk menentukan objek apa yang dibuat
        @Override
        public Baterai deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            
            // Cek apakah ada label TIPE_CLASS
            if (jsonObject.has("TIPE_CLASS")) {
                String tipe = jsonObject.get("TIPE_CLASS").getAsString();
                if (tipe.equals("SecondLifeBattery")) {
                    return context.deserialize(json, SecondLifeBattery.class);
                } else if (tipe.equals("EVBattery")) {
                    return context.deserialize(json, EVBattery.class);
                }
            }
            
            // Cara cadangan jika JSON lama tidak punya label (menebak dari isi data)
            if (jsonObject.has("idSertifikat")) {
                return context.deserialize(json, SecondLifeBattery.class);
            } else {
                return context.deserialize(json, EVBattery.class);
            }
        }
    }

    // 2. DAFTARKAN ADAPTER KE DALAM GSON
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Baterai.class, new BateraiAdapter()) // <- Ini kuncinya!
            .create();

    // ==========================================
    // METHOD SIMPAN & MUAT (TETAP SAMA)
    // ==========================================

    public static void simpanData(List<User> daftarPengguna) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(daftarPengguna, writer);
            System.out.println("✅ Data berhasil disimpan secara permanen ke: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Gagal menyimpan data: " + e.getMessage());
        }
    }

    public static List<User> muatData() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            List<User> data = gson.fromJson(reader, listType);
            
            if (data == null) {
                return new ArrayList<>(); 
            }
            System.out.println("✅ Data sebelumnya berhasil dimuat dari: " + FILE_NAME);
            return data;
        } catch (IOException e) {
            System.out.println("ℹ️ Tidak ada data penyimpanan sebelumnya. Memulai sistem dengan data kosong.");
            return new ArrayList<>();
        }
    }
}