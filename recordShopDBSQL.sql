INSERT INTO public.albums(
	title, artist, genre, "releaseYear", description)
	VALUES ('Future Nostalgia', 'Dua Lipa', 'Pop', 2020, 'An amazing pop album that saved me through the pandemic!!'),
	('Materia Prisma', 'Marco Mengoni', 'Pop', 2023, 'Such a talented singer, took over the stage at Eurovision'),
	('Un Verano Sin Ti', 'Bad Bunny', 'Latin music', 2022, 'Latin-American music perfect for parties!');

SELECT id, title, artist, genre, "releaseYear", description FROM public.albums;