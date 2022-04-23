PGDMP     -                    z           postgres    14.1    14.1 8    1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            4           1262    13754    postgres    DATABASE     i   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Bulgarian_Bulgaria.1251';
    DROP DATABASE postgres;
                postgres    false            5           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3380                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            6           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16394    configurations    TABLE     �  CREATE TABLE public.configurations (
    active_time integer NOT NULL,
    monday character varying,
    tuesday character varying,
    wednesday character varying,
    thursday character varying,
    friday character varying,
    saturday character varying,
    sunday character varying,
    configuration_changed_by integer NOT NULL,
    valve_id integer NOT NULL,
    configuration_id integer NOT NULL
);
 "   DROP TABLE public.configurations;
       public         heap    postgres    false            �            1259    16399 #   configurations_configuration_id_seq    SEQUENCE     �   CREATE SEQUENCE public.configurations_configuration_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.configurations_configuration_id_seq;
       public          postgres    false    210            7           0    0 #   configurations_configuration_id_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.configurations_configuration_id_seq OWNED BY public.configurations.configuration_id;
          public          postgres    false    211            �            1259    16400    devices    TABLE     �   CREATE TABLE public.devices (
    device_name character varying NOT NULL,
    device_location character varying NOT NULL,
    device_id integer NOT NULL
);
    DROP TABLE public.devices;
       public         heap    postgres    false            �            1259    16405    devices_device_id_seq    SEQUENCE     �   CREATE SEQUENCE public.devices_device_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.devices_device_id_seq;
       public          postgres    false    212            8           0    0    devices_device_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.devices_device_id_seq OWNED BY public.devices.device_id;
          public          postgres    false    213            �            1259    16411    logs_log_id_seq    SEQUENCE     �   CREATE SEQUENCE public.logs_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 &   DROP SEQUENCE public.logs_log_id_seq;
       public          postgres    false            �            1259    16406    logs    TABLE       CREATE TABLE public.logs (
    log_date timestamp without time zone NOT NULL,
    log_description character varying NOT NULL,
    log_level character varying NOT NULL,
    user_id integer NOT NULL,
    log_id integer DEFAULT nextval('public.logs_log_id_seq'::regclass) NOT NULL
);
    DROP TABLE public.logs;
       public         heap    postgres    false    215            �            1259    16412    sensor_types    TABLE     �   CREATE TABLE public.sensor_types (
    sensor_type_id integer NOT NULL,
    sensor_type character varying NOT NULL,
    data_type character varying NOT NULL
);
     DROP TABLE public.sensor_types;
       public         heap    postgres    false            �            1259    16417     sensor_types_sensor_types_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sensor_types_sensor_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 7   DROP SEQUENCE public.sensor_types_sensor_types_id_seq;
       public          postgres    false            �            1259    16418    sensors    TABLE     |   CREATE TABLE public.sensors (
    sensor_type_id integer NOT NULL,
    sensor_id integer NOT NULL,
    device_id integer
);
    DROP TABLE public.sensors;
       public         heap    postgres    false            �            1259    16421    sensors_sensor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sensors_sensor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.sensors_sensor_id_seq;
       public          postgres    false    218            9           0    0    sensors_sensor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.sensors_sensor_id_seq OWNED BY public.sensors.sensor_id;
          public          postgres    false    219            �            1259    16427    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false            �            1259    16422    users    TABLE     I  CREATE TABLE public.users (
    user_id integer DEFAULT nextval('public.users_user_id_seq'::regclass) NOT NULL,
    user_full_name character varying NOT NULL,
    user_login character varying NOT NULL,
    user_pass character varying NOT NULL,
    user_create_date timestamp without time zone,
    user_admin boolean NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false    221            �            1259    16428    valves    TABLE     i   CREATE TABLE public.valves (
    valve_id integer NOT NULL,
    valve_name character varying NOT NULL
);
    DROP TABLE public.valves;
       public         heap    postgres    false            �            1259    16433    valves_valve_id_seq    SEQUENCE     �   CREATE SEQUENCE public.valves_valve_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 *   DROP SEQUENCE public.valves_valve_id_seq;
       public          postgres    false            {           2604    16434    configurations configuration_id    DEFAULT     �   ALTER TABLE ONLY public.configurations ALTER COLUMN configuration_id SET DEFAULT nextval('public.configurations_configuration_id_seq'::regclass);
 N   ALTER TABLE public.configurations ALTER COLUMN configuration_id DROP DEFAULT;
       public          postgres    false    211    210            |           2604    16435    devices device_id    DEFAULT     v   ALTER TABLE ONLY public.devices ALTER COLUMN device_id SET DEFAULT nextval('public.devices_device_id_seq'::regclass);
 @   ALTER TABLE public.devices ALTER COLUMN device_id DROP DEFAULT;
       public          postgres    false    213    212            ~           2604    16436    sensors sensor_id    DEFAULT     v   ALTER TABLE ONLY public.sensors ALTER COLUMN sensor_id SET DEFAULT nextval('public.sensors_sensor_id_seq'::regclass);
 @   ALTER TABLE public.sensors ALTER COLUMN sensor_id DROP DEFAULT;
       public          postgres    false    219    218            !          0    16394    configurations 
   TABLE DATA           �   COPY public.configurations (active_time, monday, tuesday, wednesday, thursday, friday, saturday, sunday, configuration_changed_by, valve_id, configuration_id) FROM stdin;
    public          postgres    false    210   �@       #          0    16400    devices 
   TABLE DATA           J   COPY public.devices (device_name, device_location, device_id) FROM stdin;
    public          postgres    false    212   �@       %          0    16406    logs 
   TABLE DATA           U   COPY public.logs (log_date, log_description, log_level, user_id, log_id) FROM stdin;
    public          postgres    false    214   .A       '          0    16412    sensor_types 
   TABLE DATA           N   COPY public.sensor_types (sensor_type_id, sensor_type, data_type) FROM stdin;
    public          postgres    false    216   �A       )          0    16418    sensors 
   TABLE DATA           G   COPY public.sensors (sensor_type_id, sensor_id, device_id) FROM stdin;
    public          postgres    false    218   �A       +          0    16422    users 
   TABLE DATA           m   COPY public.users (user_id, user_full_name, user_login, user_pass, user_create_date, user_admin) FROM stdin;
    public          postgres    false    220   0B       -          0    16428    valves 
   TABLE DATA           6   COPY public.valves (valve_id, valve_name) FROM stdin;
    public          postgres    false    222   �B       :           0    0 #   configurations_configuration_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.configurations_configuration_id_seq', 1, true);
          public          postgres    false    211            ;           0    0    devices_device_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.devices_device_id_seq', 1, true);
          public          postgres    false    213            <           0    0    logs_log_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.logs_log_id_seq', 7, true);
          public          postgres    false    215            =           0    0     sensor_types_sensor_types_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.sensor_types_sensor_types_id_seq', 1, false);
          public          postgres    false    217            >           0    0    sensors_sensor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.sensors_sensor_id_seq', 4, true);
          public          postgres    false    219            ?           0    0    users_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.users_user_id_seq', 5, true);
          public          postgres    false    221            @           0    0    valves_valve_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.valves_valve_id_seq', 1, false);
          public          postgres    false    223            �           2606    16438 "   configurations configurations_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.configurations
    ADD CONSTRAINT configurations_pkey PRIMARY KEY (configuration_id);
 L   ALTER TABLE ONLY public.configurations DROP CONSTRAINT configurations_pkey;
       public            postgres    false    210            �           2606    16440    devices devices_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_pkey PRIMARY KEY (device_id);
 >   ALTER TABLE ONLY public.devices DROP CONSTRAINT devices_pkey;
       public            postgres    false    212            �           2606    16442    logs logs_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.logs
    ADD CONSTRAINT logs_pkey PRIMARY KEY (log_id);
 8   ALTER TABLE ONLY public.logs DROP CONSTRAINT logs_pkey;
       public            postgres    false    214            �           2606    16444    sensor_types sensor_types_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.sensor_types
    ADD CONSTRAINT sensor_types_pkey PRIMARY KEY (sensor_type_id);
 H   ALTER TABLE ONLY public.sensor_types DROP CONSTRAINT sensor_types_pkey;
       public            postgres    false    216            �           2606    16446    sensors sensors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.sensors
    ADD CONSTRAINT sensors_pkey PRIMARY KEY (sensor_id);
 >   ALTER TABLE ONLY public.sensors DROP CONSTRAINT sensors_pkey;
       public            postgres    false    218            �           2606    16448    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    220            �           2606    16450    valves valves_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.valves
    ADD CONSTRAINT valves_pkey PRIMARY KEY (valve_id);
 <   ALTER TABLE ONLY public.valves DROP CONSTRAINT valves_pkey;
       public            postgres    false    222            �           1259    16451 "   fki_configurations_valves_valve_id    INDEX     a   CREATE INDEX fki_configurations_valves_valve_id ON public.configurations USING btree (valve_id);
 6   DROP INDEX public.fki_configurations_valves_valve_id;
       public            postgres    false    210            �           1259    16452    fki_logs_users_user_id    INDEX     J   CREATE INDEX fki_logs_users_user_id ON public.logs USING btree (user_id);
 *   DROP INDEX public.fki_logs_users_user_id;
       public            postgres    false    214            �           1259    16453    fki_sensors_devices_device_id    INDEX     V   CREATE INDEX fki_sensors_devices_device_id ON public.sensors USING btree (device_id);
 1   DROP INDEX public.fki_sensors_devices_device_id;
       public            postgres    false    218            �           1259    16454 '   fki_sensors_sensor_types_sensor_type_id    INDEX     e   CREATE INDEX fki_sensors_sensor_types_sensor_type_id ON public.sensors USING btree (sensor_type_id);
 ;   DROP INDEX public.fki_sensors_sensor_types_sensor_type_id;
       public            postgres    false    218            �           2606    16455 -   configurations configurations_valves_valve_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.configurations
    ADD CONSTRAINT configurations_valves_valve_id FOREIGN KEY (valve_id) REFERENCES public.valves(valve_id) NOT VALID;
 W   ALTER TABLE ONLY public.configurations DROP CONSTRAINT configurations_valves_valve_id;
       public          postgres    false    210    3217    222            �           2606    16460    logs logs_users_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.logs
    ADD CONSTRAINT logs_users_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id) NOT VALID;
 A   ALTER TABLE ONLY public.logs DROP CONSTRAINT logs_users_user_id;
       public          postgres    false    214    3215    220            �           2606    16465 !   sensors sensors_devices_device_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.sensors
    ADD CONSTRAINT sensors_devices_device_id FOREIGN KEY (device_id) REFERENCES public.devices(device_id) NOT VALID;
 K   ALTER TABLE ONLY public.sensors DROP CONSTRAINT sensors_devices_device_id;
       public          postgres    false    218    212    3204            �           2606    16470 +   sensors sensors_sensor_types_sensor_type_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.sensors
    ADD CONSTRAINT sensors_sensor_types_sensor_type_id FOREIGN KEY (sensor_type_id) REFERENCES public.sensor_types(sensor_type_id) NOT VALID;
 U   ALTER TABLE ONLY public.sensors DROP CONSTRAINT sensors_sensor_types_sensor_type_id;
       public          postgres    false    218    3209    216            !      x�36���ÂA�+F��� �a�      #   0   x����Q����,�/�LO,JI�S�U(�L�(Q(�LI�4����� !iv      %   k   x���1� Й����D=�+&J��?����'�U�gM�&�D��3����p�x��[T��D^�xƺ)Ŕ���l/p��ix��M)9��#�  ILZQ      '   E   x�3�I�-H-J,)-J�L��O,�2�������+�2��(��L�,��ʙp:f)�#4��qqq ���      )   "   x�3�4���2�4QƜ� ʄ�D��qqq \�U      +   A   x�3��,K����̄P�F�&�1~�%\F8e�9�K�+�3�H�p�����)gz*bJ��qqq ��(?      -      x�3��M��S(K�)K����� 1��     