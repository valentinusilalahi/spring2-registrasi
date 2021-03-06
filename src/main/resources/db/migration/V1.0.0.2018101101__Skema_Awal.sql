CREATE TABLE sekolah (
  id                INTEGER,
  kat               VARCHAR(255) NOT NULL,
  jenis_sekolah_id  VARCHAR(36)  NOT NULL,
  nspn              VARCHAR(255) NOT NULL,
  nama_sekolah      VARCHAR(255) NOT NULL,
  alamat            VARCHAR(255) NOT NULL,
  kokab             VARCHAR(255) NOT NULL,
  kontak            VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (nspn)
);

CREATE TABLE provinsi(
	id VARCHAR (36),
	nama VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE kabupate_kota(
	id VARCHAR(36),
	nama VARCHAR(255),
	id_provinsi VARCHAR(36),
	PRIMARY KEY(id),
	FOREIGN KEY (id_provinsi) REFERENCES provinsi(id)
);

CREATE TABLE registrasi_awal (
  id                      VARCHAR (36),
  nama                    VARCHAR (255) NOT NULL,
  no_hp                   VARCHAR (13)  NOT NULL,
  email                   VARCHAR (255) NOT NULL,
  negara                  VARCHAR (255) NOT NULL,
  kota_asal_sekolah       VARCHAR (255) NOT NULL,
  nama_asal_sekolah       VARCHAR (255) NOT NULL,
  pemberi_rekomendasi     VARCHAR (255) NOT NULL,
  nama_perekomendasi      VARCHAR (255),
  program_studi_pilihan   VARCHAR (255) NOT NULL,
  konsentrasi             VARCHAR (255)  NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email)
 );
 
 CREATE TABLE registrasi_akhir (
  id                    VARCHAR (36),
  nama                  VARCHAR (255) NOT NULL,
  ttl                   VARCHAR (255) NOT NULL,
  jenis_kelamin         VARCHAR (13) NOT NULL,
  golongan_darah        VARCHAR (36) NOT NULL,
  no_ktp                VARCHAR (36) NOT NULL,
  alamat_rumah          VARCHAR (255) NOT NULL,
  provinsi              VARCHAR (255) NOT NULL,
  kokab                 VARCHAR (255) NOT NULL,
  kode_pos              VARCHAR (255) NOT NULL,
  no_hp                 VARCHAR (36) NOT NULL,
  email                 VARCHAR (36) NOT NULL,
  kokab_sekolah         VARCHAR (255) NOT NULL,
  asal_sekolah          VARCHAR (255) NOT NULL,
  jurusan_sekolah       VARCHAR (36) NOT NULL,
  nisn                  VARCHAR (255) NOT NULL,
  tahun_lulus_sekolah   VARCHAR (255) NOT NULL,
  pekerjaan_pribadi     VARCHAR (255) NOT NULL,
  penghasilan_pribadi   VARCHAR (255) NOT NULL,
  status_sipil          VARCHAR (255) NOT NULL,
  nama_ayah             VARCHAR (255) NOT NULL,
  agama_ayah            VARCHAR (255) NOT NULL,
  pendidikan_ayah       VARCHAR (255) NOT NULL,
  pekerjaan_ayah        VARCHAR (255) NOT NULL,
  nama_ibu              VARCHAR (255) NOT NULL,
  agama_ibu             VARCHAR (255) NOT NULL,
  pendidikan_ibu        VARCHAR (255) NOT NULL,
  pekerjaan_ibu         VARCHAR (255) NOT NULL,
  alamat_orangtua       VARCHAR (255) NOT NULL,
  kokab_orangtua        VARCHAR (255) NOT NULL,
  nohp_orangtua         VARCHAR (36) NOT NULL,
  email_orangtua        VARCHAR (255),
  penghasilan_orangtua  VARCHAR (255) NOT NULL,
  jumlah_tanggungan     VARCHAR (36) NOT NULL,
  rencana_biaya         VARCHAR (36) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (no_ktp)
 );