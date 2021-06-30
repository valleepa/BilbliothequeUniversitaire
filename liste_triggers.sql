create trigger CHECK_EMPRUNT_LIMIT
    before insert
    on EMPRUNT
    for each row
DECLARE
    nb_emprunt number;
BEGIN
    SELECT COUNT(*) INTO nb_emprunt FROM EMPRUNT WHERE ID_ET = :new.ID_ET AND DATE_RETOUR IS NULL;
    if nb_emprunt >= 5 THEN -- erreur si le nombre d'emprunt était à 5 car il va passer à 6 sinon
        raise_application_error(-20000,'Nombre d emprunt maximum atteint');
    end if;
END;
/

create trigger ETUDIANTTRIG
    before insert
    on ETUDIANT
    for each row
begin
  SELECT IDSEQET.nextval into :NEW.ID_ET from dual;
end;
/


create trigger EXEMPLAIRETRIG
    before insert
    on EXEMPLAIRE
    for each row
begin
  SELECT IDSEQEX.nextval into :NEW.ID_EX from dual;
end;
/


create trigger LIVRETRIG
    before insert
    on LIVRE
    for each row
begin
  SELECT IDSEQ.nextval into :NEW.ID_LIVRE from dual;
end;
/

create trigger CHECK_RESERV_LIMIT
    before insert
    on RESERV
    for each row
DECLARE
    nb_reserv number;
BEGIN
    SELECT COUNT(*) INTO nb_reserv FROM RESERV WHERE ID_ET = :new.ID_ET AND DATE_FIN_RES IS NULL ;
    if nb_reserv >= 5 THEN -- erreur si le nombre de reservation était à 5 car il va passer à 6 sinon
        raise_application_error(-20000,'Nombre de réservation maximum atteint');
    end if;
END;
/

