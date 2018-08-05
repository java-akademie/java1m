
package ch.jkurs.spiele.mastermind;

import ch.jmildner.tools.MyTools;

public class MasterMind
{
	public static void main(String[] args)
	{
		//
		// Ueberschrift inkl. Unterstreichung ausgeben.
		//
		System.out.println("\n\n Master-Mind mit Ziffern"); // Text nach
															// zwei
															// durch
															// '\n\n'
															// provozierten
															// Leerzeilen
															// ausgeben
		System.out.println(" -----------------------"); // Text
														// unterstreichen
		System.out.println(); // Leerzeile mit eine Einzelbefehl
								// erzeugen
		//
		// Game-Loop fuer wiederholtes spielen mit angepassten
		// Spiel-Einstellungen.
		//
		boolean gameBed = true; // definieren gameBed als boolean
								// Loop-Bedingung und Wertzuweisung true
		while (gameBed) // Game-Loop durchfuehren solange die
						// Loop-Bedingung erfuellt ist (kopfgesteuert)
		{
			//
			// Erfassen der Spiel-Parameter.
			//
			int anzVari = MyTools.getInteger(" Anzahl Ziffern der Aufgabe (2 bis 9): ", 2, 9); // Anzahl
																								// Aufgaben-Ziffern
																								// eingeben
			int vonZiffer = MyTools.getInteger(" Tiefste  moegliche Ziffer  (1 bis 8): ", 1, 8); // eingeben
																									// der
																									// tiefstm�glichen
																									// Ziffer

			int abZiff = (vonZiffer + 1); // Tiefstm�gliche Ziffer f�r
											// die n�chste Eingabe
											// berechnen und festhalten

			int bisZiffer = MyTools.getInteger(
					" Hoechste moegliche Ziffer  (" + abZiff + " bis 9): ", (vonZiffer + 1), 9); // h�chstm.
																									// Ziff.

			System.out.println(); // Leerzeile ausgeben

			String eigeneEing = MyTools
					.getString(" Selber eine Aufgabe erfassen? (default nein / j): "); // eigene
																						// Aufgabe
																						// eingeben?

			char[] aufgZiff = new char[anzVari]; // Character
													// Aufgabe-Array
													// definieren
			char charZeichen; // definieren charZeichen f�r das
								// �bertragen von Einzelzeichen
			boolean pgmEnde = false; // definieren pgmEnde als
										// boolean-Datentyp und
										// Wertzuweisung false
			boolean mehrfVork = true; // Mehrfachvorkommen von Ziffern
										// auf zul�ssig initialisieren
			boolean firstGame = true; // definieren firstGame als Flag
										// mit boolean-Datentyp und
										// Wertzuweisung true
			//
			// Gleiche-Einstellungen Loop f�r wiederholtes spielen mit
			// den gleichen Spiel-Eintellungen.
			//
			boolean gleicheEinst = true; // definieren gleicheEinst als
											// boolean Loop-Bedingung
											// und Wertzuweisung true
			while (gleicheEinst) // Gleiche-Einstellungen-Loop
									// durchf�hren solange die
									// Loop-Bedingung erf�llt ist
			{
				//
				// Pr�fen, ob einen eigene Aufgaben-Eingabe erfolgen
				// soll. Wenn ja, Aufgaben-Eingabe erm�glichen.
				// Wenn nein, ggf. abfragen ob Mehrfachvorkommen
				// zugelassen wird.
				//
				if (eigeneEing.equals("j")) // Wenn eine eigene Aufgabe
											// eingegeben werden soll
				{
					//
					// do-while - Loop bis eine g�ltige Aufgabe
					// eingegeben wurde.
					//
					boolean abbrBed; // definieren abbrBed als boolean
										// Loop-Bedingung
					do // do-while Loop bis eine zul�ssige Aufgabe
						// eingegeben wurde
					{
						String eigeneAufgabe = MyTools
								.getString("\n\n Eigene Aufgabe eingeben :  "); // Eingabe
																				// eigene
																				// Aufgabe

						abbrBed = true; // do-while Abbruch-Bedingung
										// auf erf�llt setzen, was den
										// do-while Loop beenden w�rde

						if (eigeneAufgabe.length() != anzVari) // Wenn
																// Anzahl
																// eingegebene
																// Stellen
																// ungleich
																// der
																// Aufgaben-Stellen
						{
							System.out.println(" Ungueltige Eingabe! Es muessen " + anzVari
									+ " Stellen eingegeben werden"); // Fehlertext

							abbrBed = false; // Loop Abbruch-Bedingung
												// auf false setzen.
												// Loop l�uft weiter
						}
						else // Die Anzahl eingegebener Stellen ist
								// korrekt
						{
							//
							// Die eingegebene Aufgabe in das Array
							// aufZiff �bernehmen und gleichzeitig auf
							// g�ltige Eingabe pr�fen.
							//
							for (int i = 0; i < aufgZiff.length; i++) // Loop
																		// von
																		// int
																		// i=0
																		// bis
																		// Anz.
																		// Array-Elemente
																		// mit
																		// Inkrement.
																		// i+1
							{
								charZeichen = eigeneAufgabe.charAt(i); // charZeichen
																		// mit
																		// der
																		// Ziffer
																		// an
																		// der
																		// Stelle
																		// i
																		// des
																		// Strings
																		// abf�llen
								aufgZiff[i] = charZeichen; // Character-Zeichen
															// in das
															// Array
															// aufgZiff
															// �bernehmen

								int aufgInt = charZeichen - '0'; // Numerisches
																	// Character-Zeichen
																	// in
																	// einen
																	// Integer
																	// umwandeln

								if (aufgInt < vonZiffer || aufgInt > bisZiffer) // Pr�fen
																				// auf
																				// g�ltigen
																				// Eingabe-Wert
								{
									System.out.println(" Ungueltige Eingabe " + charZeichen
											+ "! Zulaessig sind die Ziffern " + vonZiffer + " bis "
											+ bisZiffer);

									abbrBed = false; // Loop
														// Abbruch-Bedingung
														// auf false
														// setzen. Loop
														// l�uft weiter
								}
							}
						}

					}
					while (abbrBed == false); // do-while - Loop l�uft
												// fussgesteuert solange
												// keine zul�ssige
												// Aufgabe eingegeben
												// wurde
				}
				else // Das System soll eine Zufalls-Aufgabe generieren
				{
					//
					// Wenn es sich um den ersten Durchlauf mit neuen
					// Spiel-Einstellungen handelt, so wird gepr�ft, ob
					// es die bisher gew�hlten
					// Einstellungen erlauben, ein Mehrfachvorkommen von
					// Ziffern durch den Benutzer ggf. sperren zu
					// lassen.
					//
					if (firstGame) // Pr�fen, ob erster Durchlauf mit
									// neuen Einstellungen
					{
						if (anzVari <= (bisZiffer - vonZiffer + 1)) // Pr�fen,
																	// ob
																	// betr.
																	// Anzahl
																	// Stellen
																	// gen�gend
																	// verschiedene
																	// Ziffern
																	// erlaubt
																	// sind
						{
							String gleicheZiff = MyTools.getString(
									" Mehrfachvorkommen erlaubt?    (default  ja  / n): "); // Mehrfachvorkommen
																							// abfragen

							if (gleicheZiff.equals("n")) // Wenn
															// mehrfachvorkommende
															// Ziffern
															// nicht
															// erlaubt
															// sind
							{
								mehrfVork = false; // Mehrfachvorkommen
													// von Ziffern wird
													// nicht zugelassen
							}
						}
						else // f�r das F�llen aller Aufgaben-Ziffern
								// sind zuwenig verschiedene Ziffern
								// zugelassen
						{
							System.out.println(
									"\n Mehrfachvorkommen von Ziffern ist zwingend noetig!"); // Informations-Text
																								// ausgeben
						}
					}
					//
					// Zufalls-Aufgabe vom System generieren lassen.
					//
					int[] aufgabe = new int[anzVari]; // Integer
														// Aufgabe-Array
														// definieren

					for (int i = 0; i < aufgabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// und
																// Inkrementierung
																// i+1
					{
						//
						// Es wird solange eine Aufgaben-Ziffer
						// zufallsm�ssig bestimmt, bis diese gem�ss den
						// Rahmenbedingungen akzeptiert werden kann
						//
						boolean abbrBed; // definieren abbrBed als
											// boolean Loop-Bedingung
						do // do-while - Loop bis eine akzeptable Ziffer
							// generiert wurde
						{
							aufgabe[i] = MyTools.getRandom(vonZiffer, bisZiffer); // Ziffer
																					// mit
																					// Zufallswert
																					// im
																					// Von-/Bis-Bereich
																					// generieren
																					// lassen
							//
							// Die do-while Bedingung wird auf true
							// initialisiert, was einen Loop-Abruch
							// provozieren w�rde.
							//
							abbrBed = true; // do-while
											// Abbruch-Bedingung auf
											// erf�llt setzen
							//
							// Wenn kein Mehrfachvorkommen zugelassen
							// wird, so muss gepr�ft werden, ob die
							// Ziffer schon in einem Array-Element
							// vorkommt. Wenn ja, so wird die do-while
							// Abbruch-Bedingung auf false gesetzt, so
							// dass im Loop eine neue Ziffer generiert
							// wird.
							//
							if (mehrfVork == false) // Wenn
													// mehrfachvorkommende
													// Ziffern nicht
													// erlaubt sind
							{
								for (int j = 0; j < i; j++) // Loop
															// solange j
															// kleiner i
															// ist
								{
									if (aufgabe[i] == aufgabe[j]) // Wenn
																	// die
																	// Ziffer
																	// in
																	// der
																	// Aufgabe
																	// bereits
																	// vorkommt
									{
										abbrBed = false; // Loop
															// Abbruch-Bedingung
															// auf false
															// setzen.
															// Loop
															// l�uft
															// weiter
									}
								}
							}

						}
						while (abbrBed == false); // do-while - Loop
													// solange keine
													// akzeptable Ziffer
													// gefunden wurde
						//
						// Character-Array in Abh�ngigkeit der
						// generierten Integer-Array-Ziffern abf�llen.
						//
						switch (aufgabe[i]) // Abfragen der Elemente im
											// Array aufgabe
						{
							case 1: // Wenn im Element des Array aufgabe
									// die Ziffer 1 steht
								aufgZiff[i] = '1'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 2: // Wenn im Element des Array aufgabe
									// die Ziffer 2 steht
								aufgZiff[i] = '2'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 3: // Wenn im Element des Array aufgabe
									// die Ziffer 3 steht
								aufgZiff[i] = '3'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 4: // Wenn im Element des Array aufgabe
									// die Ziffer 4 steht
								aufgZiff[i] = '4'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 5: // Wenn im Element des Array aufgabe
									// die Ziffer 5 steht
								aufgZiff[i] = '5'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 6: // Wenn im Element des Array aufgabe
									// die Ziffer 6 steht
								aufgZiff[i] = '6'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 7: // Wenn im Element des Array aufgabe
									// die Ziffer 7 steht
								aufgZiff[i] = '7'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 8: // Wenn im Element des Array aufgabe
									// die Ziffer 8 steht
								aufgZiff[i] = '8'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden

							case 9: // Wenn im Element des Array aufgabe
									// die Ziffer 9 steht
								aufgZiff[i] = '9'; // Die Ziffer 1 in
													// das
													// Character-Array
													// aufgZiff abf�llen
								break; // case-Ausf�hrungsblock beenden
						}
					}
				}
				//
				// Bewertungs-Legende anzeigen. Spezialle Tip-Eingaben
				// anzeigen
				//
				System.out.println(
						"\n\n Auswertungs-Legende                     Spezielle Tip-Eingabe"); // �berschriften
																								// Texte
				System.out
						.println(" -------------------                     ---------------------"); // Texte
																									// unterstreichen
				System.out
						.println(" richtig positioniert =  #               -1 = Aufgabe anzeigen"); // 1.
																									// Legendenzeile
																									// ausgeben
				System.out.println(" falsch  positioniert =  X"); // 2.
																	// Legendenzeile
																	// ausgeben
				System.out.println(" kein Vorkommen       =  -"); // 3.
																	// Legendenzeile
																	// ausgeben
				System.out
						.println(" Aufreihung von links nach rechts mit Prioritaet # vor X vor -"); // 4.
																									// Legendenzeile
																									// ausgeben
				System.out.println("\n"); // Zwei Leerzeile ausgeben
				//
				// Haupt-Loop f�r die Tip-Abgabe inkl.
				// Auswertungs-Ausgabe
				//
				char[] eingabe = new char[anzVari]; // Eingabe-Array
													// definieren
				char[] auswert = new char[anzVari]; // Auswertungs-Array
													// definieren
				char[] aufgKopie = new char[anzVari]; // Array f�r die
														// Aufgaben-Kopie
														// definieren

				int tipZahl = 0; // definieren tipZahl f�r die Anzeige
									// von z.B. "Ihr 4. Tip :"
				boolean loopBed = true; // definieren loopBed als
										// Loop-Bedingung mit
										// boolean-Datentyp und
										// Wertzuweisung true

				while (loopBed) // Haupt-Loop durchf�hren solange die
								// Loop-Bedingung erf�llt ist
								// (kopfgesteuert)
				{
					tipZahl++; // Tip-Z�hler inkrementieren
					//
					// Die Tip-Eingabe soll auch noch ab dem 10. Tip
					// unteireinander ausgerichtet bleiben.
					//
					String ihrTip; // Definieren des Strings ihrTip

					boolean abbrBed; // definieren abbrBed als
										// Loop-Bedingung mit
										// boolean-Datentyp
					do // do-while Loop - bis ein akzeptabler Tip
						// abgegeben wurde
					{
						System.out.println(); // Leerzeile ausgeben

						if (tipZahl < 10) // Pr�fen, ob Tip-Eingabe 1
											// bis 9
						{
							String eingabeTip = MyTools
									.getString(" Dein  " + tipZahl + ". Tip :  "); // 1.
																					// bis
																					// 9.
																					// Tip-Eingabe
																					// entgegen
																					// nehmen
							ihrTip = eingabeTip; // eingegebenen Tip
													// �bernehmen
						}
						else
						{
							String eingabeTip = MyTools.getString(" Dein " + tipZahl + ". Tip :  "); // 10.
																										// bis
																										// n.
																										// Tip-Eingabe
																										// entgegen
																										// nehmen
							ihrTip = eingabeTip; // eingegebenen Tip
													// �bernehmen
						}
						//
						// Pr�fen, ob das Eingeben von Tips abgebrochen
						// werden soll.
						//
						if (ihrTip.equals("-1")) // Wenn als Tip der
													// Wert -1
													// eingegeben wurde
						{
							pgmEnde = true; // Flag pgmEnde auf true
											// setzen
							break; // Die aktuelle do-while-Schlaufe
									// wird sofort beendet
						}
						//
						// Die do-while Bedingung wird auf true
						// initialisiert, was einen Loop-Abruch
						// provozieren w�rde.
						//
						abbrBed = true; // do-while Abbruch-Bedingung
										// auf erf�llt setzen

						if (ihrTip.length() != anzVari) // Wenn Anzahl
														// eingegebene
														// Stellen
														// ungleich der
														// Anzahl
														// Aufgaben-Stellen
						{
							System.out.println(" Ungueltige Eingabe! Es muessen " + anzVari
									+ " Stellen eingegeben werden"); // Fehlertext

							abbrBed = false; // Loop Abbruch-Bedingung
												// auf false setzen.
												// Loop l�uft weiter
						}
						else // Die Anzahl eingegebener Stellen ist
								// korrekt
						{
							//
							// Den eingegebenen Tip in die Elemente des
							// Array einabe �bernehmen und gleichzeitig
							// auf g�ltige Eingabe pr�fen.
							//
							for (int i = 0; i < eingabe.length; i++) // Loop
																		// von
																		// int
																		// i=0
																		// bis
																		// Anzahl
																		// Array-Elemente
																		// mit
																		// Inkrementierung
																		// i+1
							{
								charZeichen = ihrTip.charAt(i); // charZeichen
																// mit
																// der
																// Ziffer
																// an
																// der
																// Stelle
																// i des
																// Strings
																// abf�llen
								eingabe[i] = charZeichen; // Ziffer in
															// das Array
															// eingabe
															// �bernehmen
								auswert[i] = ' '; // Auswertungs-Array
													// initialisieren
								aufgKopie[i] = aufgZiff[i]; // Aufgaben-Kopie
															// Array mit
															// den
															// Aufgabenziffern
															// abf�llen
															// (Kopie
															// erstellen)

								int aufgInt = charZeichen - '0'; // Numerisches
																	// Character-Zeichen
																	// in
																	// einen
																	// Integer
																	// umwandeln

								if (aufgInt < vonZiffer || aufgInt > bisZiffer) // Pr�fen
																				// auf
																				// g�ltigen
																				// Eingabe-Wert
								{
									System.out.println(" Ungueltige Eingabe " + charZeichen
											+ "! Zulaessig sind die Ziffern " + vonZiffer + " bis "
											+ bisZiffer);

									abbrBed = false; // Loop
														// Abbruch-Bedingung
														// auf false
														// setzen. Loop
														// l�uft weiter
								}
							}
						}
					}
					while (abbrBed == false); // do-while - Loop solange
												// kein akzeptabler Tip
												// eingegeben wurde
					//
					// Pr�fen, ob das Eingeben von Tips abgebrochen
					// wurde.
					//
					if (pgmEnde) // Das Flag betreffend Programm-Ende
									// ist gesetzt, die Tip-eingabe
									// wurde abgebrochen
					{
						break; // Die aktuelle while-Schlaufe des
								// Haupt-Loops wird sofort beendet
					}
					//
					// Auswerten des eingegebenen Tips. Zuerst wird nach
					// richtig positionierten Ziffern gesucht.
					//
					for (int i = 0; i < eingabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// mit
																// Inkrementierung
																// i+1
					{
						if (eingabe[i] == aufgKopie[i]) // Pr�fen auf
														// richtig
														// positionierte
														// Ziffer
						{
							auswert[i] = '#'; // '#' im
												// Auswertungs-Array f�r
												// richtig positionierte
												// Ziffer setzen
							aufgKopie[i] = ' '; // Aufgaben-Ziffer
												// ausblanken, da sie
												// abschliessend
												// ausgewertet wurde
						}
					}
					//
					// Nun wird nach falsch positionierten Ziffern
					// gesucht.
					//
					for (int i = 0; i < eingabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// mit
																// Inkrementierung
																// i+1
					{
						while (auswert[i] == ' ') // Solange an der zu
													// bewertenden
													// Position noch
													// keine Bewertung
													// steht
						{
							for (int j = 0; j < eingabe.length; j++) // Loop
																		// von
																		// int
																		// j=0
																		// bis
																		// Anzahl
																		// Array-Elemente
																		// mit
																		// Inkrementierung
																		// j+1
							{
								if ((eingabe[i] == aufgKopie[j]) && (auswert[i] == ' ')) // Wenn
																							// falsch
																							// pos.
																							// Ziffer
																							// und
																							// Auswertung
																							// noch
																							// offen
								{
									auswert[i] = 'X'; // 'X' im
														// Auswertungs-Array
														// f�r falsch
														// positionierte
														// Ziffer setzen
									aufgKopie[j] = ' '; // Aufgaben-Ziffer
														// ausblanken,
														// da sie
														// abschliessend
														// ausgewertet
														// wurde
								}
							}
							if (auswert[i] == ' ') // Wenn noch kein
													// Auswertungszeichen
													// vergeben wurde
							{
								auswert[i] = '-'; // '-' im
													// Auswertungs-Array
													// setzen, da kein
													// Vorkommen
							}
						}
					}
					//
					// Die Auswertung ist abgeschlossen. Nun gilt es die
					// Auswertungs-Zeichen in Auswertungs-Array von
					// links nach rechts
					// zu sortieren, wobei die folgende Priorisierung
					// gilt: 1. #, 2. X, 3. -
					// Zuerst werden die einzelnen Auswertungs-Zeichen
					// gez�hlt.
					//
					int anzRichtig = 0; // Z�hl-Integer f�r richtig
										// Positionierte mit Wert 0
										// definieren
					int anzFalsch = 0; // Z�hl-Integer f�r falsch
										// Positionierte mit Wert 0
										// definieren
					int anzKeinvor = 0; // Z�hl-Integer f�r nicht
										// Vorkommende mit Wert 0
										// definieren

					for (int i = 0; i < eingabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// mit
																// Inkrementierung
																// i+1
					{
						switch (auswert[i])
						{
							case '#': // Wenn Auswertungszeichen f�r
										// richtig positionierte Ziffer
								anzRichtig++; // Z�hler f�r richtig
												// positionierte Ziffern
												// inkrementieren
								break;

							case 'X': // Wenn Auswertungszeichen f�r
										// falsch positionierte Ziffer
								anzFalsch++; // Z�hler f�r falsch
												// positionierte Ziffern
												// inkrementieren
								break;

							case '-': // Wenn Auswertungszeichen f�r
										// kein Vorkommen
								anzKeinvor++; // Z�hler f�r kein
												// Vorkommen
												// inkrementieren
								break;
						}
					}
					//
					// Wenn die MasterMind-Aufgabe gel�st wurde, so wird
					// die Loop-Bedingung des Haupt-Loops auf false
					// gesetzt, so dass der
					// Loop beendet werden wird-
					//
					if (anzRichtig == anzVari) // Wenn alle Ziffern
												// richtig positioniert
												// sind
					{
						loopBed = false; // Haupt-Loop Bedingung auf
											// false setzen und so den
											// Loop-Abbruch provozieren
					}
					//
					// In Abh�ngigkeit der ermittelten Z�hlerwerte
					// werden die Auswertungszeichen im
					// Auswertungs-Array neu abgef�llt.
					//
					for (int i = 0; i < eingabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// mit
																// Inkrementierung
																// i+1
					{
						if (anzRichtig > 0) // Wenn noch
											// Auswertungszeichen '#'
											// abzuf�llen sind
						{
							auswert[i] = '#'; // '#' im
												// Auswertungs-Array f�r
												// richtig positionierte
												// Ziffer setzen
							anzRichtig--; // Z�hler f�r richtig
											// positionierte Ziffern
											// dekrementieren
						}
						else // Alle Auswertungszeichen '#' sind bereits
								// abgef�llt
						{
							if (anzFalsch > 0) // Wenn noch
												// Auswertungszeichen
												// 'X' abzuf�llen sind
							{
								auswert[i] = 'X'; // 'X' im
													// Auswertungs-Array
													// f�r falsch
													// positionierte
													// Ziffer setzen
								anzFalsch--; // Z�hler f�r falsch
												// positionierte Ziffern
												// dekrementieren
							}
							else // Alle Auswertungszeichen 'X' sind
									// bereits abgef�llt
							{
								if (anzKeinvor > 0) // Wenn noch
													// Auswertungszeichen
													// '-' abzuf�llen
													// sind
								{
									auswert[i] = '-'; // '-' im
														// Auswertungs-Array
														// f�r kein
														// Vorkommen
														// setzen
									anzKeinvor--; // Z�hler f�r kein
													// Vorkommen
													// dekrementieren
								}
							}
						}
					}
					//
					// Auswertungs-Array anzeigen.
					//
					System.out.print(" Auswertung   :  "); // Text '
															// Auswertung
															// : '
															// ausgeben

					for (int i = 0; i < eingabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// mit
																// Inkrementierung
																// i+1
					{
						System.out.print(auswert[i]); // Auswertungs-Array
														// ausgeben
					}

					System.out.println(); // Eine Leerzeilen ausgeben

				} // Ende des Haupt-Loop
				//
				// Wenn das Programm abgebrochen wurde, so wird die
				// gestellte Aufgabe angezeigt.
				//
				if (pgmEnde) // Pr�fen, ob das Programm abgebrochen
								// wurde
				{
					System.out.println("\n"); // Zwei Leerzeilen
												// ausgeben
					System.out.print(" Aufgabe  ====>  "); // Text '
															// Aufgabe
															// ===> '
															// ausgeben

					for (int i = 0; i < eingabe.length; i++) // Loop von
																// int
																// i=0
																// bis
																// Anzahl
																// Array-Elemente
																// mit
																// Inkrementierung
																// i+1
					{
						System.out.print(aufgZiff[i]); // Aufgaben-Array
														// ausgeben
					}
					System.out.println("\n"); // Zwei Leerzeilen
												// ausgeben

					pgmEnde = false; // Programmende-Flag f�r die ggf.
										// folgenden Durchl�ufe wieder
										// l�schen
				}
				else
				{
					System.out.println("\n"); // Zwei Leerzeile ausgeben
					System.out.print(" Gratulation, Aufgabe im " + tipZahl + ". Versuch geloest!"); // Gratulationstext
																									// ausgeben
					System.out.println("\n"); // Zwei Leerzeilen
												// ausgeben
				}
				//
				// Anzeigen der verschiedenen Auswahl-Punkte.
				//
				System.out.println("\n Was moechtest du als naechstes tun?"); // Leerzeile
																				// und
																				// dann
																				// Text
																				// ausgeben
				System.out.println(); // Eine Leerzeile ausgeben
				System.out.println(" Neue Aufgabe mit gleichen Einstellungen =>  1"); // 1.
																						// Auswahl
																						// anzeigen
				System.out.println(" Neue Aufgabe mit neuen Einstellungen    =>  2"); // 2.
																						// Auswahl
																						// anzeigen
				System.out.println(" Exit, Programm beenden                  =>  x"); // 3.
																						// Auswahl
																						// anzeigen
				//
				// do-while Loop durchf�hren, bis eine g�ltige Auswahl
				// eingegeben wurde.
				//
				boolean abbrBed; // definieren abbrBed als boolean
									// Loop-Bedingung
				do // do-while Loop bis eine g�ltige Auswahl eingegeben
					// wurde
				{
					System.out.println(); // Leerzeile ausgeben
					String deineWahl = MyTools
							.getString("                               Deine Wahl :  "); // Wahl
																							// entgegen
																							// nehmen

					abbrBed = true; // do-while Abbruch-Bedingung auf
									// erf�llt setzen, was den do-while
									// Loop beenden w�rde

					if (deineWahl.length() != 1) // Wenn nicht genau ein
													// Zeichen
													// eingegeben wurde
					{
						System.out.println(
								" Ungueltige Eingabe! Es muss genau ein Zeichen eingegeben werden"); // Fehlertext

						abbrBed = false; // Loop Abbruch-Bedingung auf
											// false setzen. Loop l�uft
											// weiter
					}
					else // Die Anzahl eingegebener Stellen ist korrekt
					{
						//
						// Pr�fen, ob das eingegebene Zeichen eine
						// g�ltige Auswahl ist. Wenn ja, so erfolgen die
						// weiteren Aktionen gem�ss der Auswahl.
						// Bei einer ung�ltigen Auswahl wird ein
						// entsprechender Fehlertext ausgegeben.
						//
						if (deineWahl.equals("x")) // Wenn Exit gew�hlt
													// wurde
						{
							gameBed = false; // Die Loop-Bedingung f�r
												// den Game-Loop wird
												// gel�scht
							gleicheEinst = false; // Die Loop-Bedingung
													// f�r den
													// Gleiche-Einstellungen-Loop
													// wird gel�scht
							System.out.println("\n\n"); // Zwei
														// Leerzeilen
														// ausgeben
						}
						else
						{
							if (deineWahl.equals("2")) // Wenn neue
														// Aufgabe mit
														// neuen
														// Einstellungen
														// gew�hlt wurde
							{
								gleicheEinst = false; // Die
														// Loop-Bedingung
														// f�r den
														// Gleiche-Einstellungen-Loop
														// wird gel�scht
								System.out.println("\n\n"); // Zwei
															// Leerzeilen
															// ausgeben
							}
							else
							{
								if (deineWahl.equals("1") == false) // Wenn
																	// eine
																	// ung�ltige
																	// Auswahl
																	// eingegeben
																	// wurde
								{
									System.out.println(
											" Ungueltige Eingabe! Zulaessig sind die Eingaben 1, 2 und x"); // Fehlertext

									abbrBed = false; // Loop
														// Abbruch-Bedingung
														// auf false
														// setzen. Loop
														// l�uft weiter
								}
								else // Wenn neue Aufgabe mit gleichen
										// Einstellungen gew�hlt wurde
								{
									firstGame = false; // Das Flag
														// betreffend
														// erstem
														// Durchlauf mit
														// neuen
														// Einstellungen
														// l�schen
								}
							}
						}
					}

				}
				while (abbrBed == false); // do-while - Loop solange
											// keine g�ltige Auswahl
											// eingegeben wurde

			} // Ende Gleiche-Einstellungen-Loop

		} // Ende Game-Loop
	}
}
