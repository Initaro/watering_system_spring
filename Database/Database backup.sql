PGDMP                         z           postgres     11.14 (Raspbian 11.14-0+deb10u1)    14.0 K    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13101    postgres    DATABASE     ]   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'bg_BG.UTF-8';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3016            �            1259    40983    configurations    TABLE     w  CREATE TABLE public.configurations (
    active_time integer NOT NULL,
    configuration_changed_by integer NOT NULL,
    valve_id integer NOT NULL,
    configuration_id integer NOT NULL,
    monday boolean,
    tuesday boolean,
    wednesday boolean,
    thursday boolean,
    friday boolean,
    saturday boolean,
    sunday boolean,
    watering_active_counter integer
);
 "   DROP TABLE public.configurations;
       public            postgres    false            �            1259    49163 #   configurations_configuration_id_seq    SEQUENCE     �   CREATE SEQUENCE public.configurations_configuration_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.configurations_configuration_id_seq;
       public          postgres    false    199            �           0    0 #   configurations_configuration_id_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.configurations_configuration_id_seq OWNED BY public.configurations.configuration_id;
          public          postgres    false    204            �            1259    41005    devices    TABLE     �   CREATE TABLE public.devices (
    device_name character varying NOT NULL,
    device_location character varying NOT NULL,
    device_id integer NOT NULL,
    user_id integer,
    device_endpoint character varying
);
    DROP TABLE public.devices;
       public            postgres    false            �            1259    49197    devices_device_id_seq    SEQUENCE     �   CREATE SEQUENCE public.devices_device_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.devices_device_id_seq;
       public          postgres    false    201            �           0    0    devices_device_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.devices_device_id_seq OWNED BY public.devices.device_id;
          public          postgres    false    206            �            1259    24580    logs_log_id_seq    SEQUENCE     �   CREATE SEQUENCE public.logs_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 &   DROP SEQUENCE public.logs_log_id_seq;
       public          postgres    false            �            1259    40961    logs    TABLE       CREATE TABLE public.logs (
    log_date timestamp without time zone NOT NULL,
    log_description character varying NOT NULL,
    log_level character varying NOT NULL,
    user_id integer NOT NULL,
    log_id integer DEFAULT nextval('public.logs_log_id_seq'::regclass) NOT NULL
);
    DROP TABLE public.logs;
       public            postgres    false    196            �            1259    65556    sensor_data    TABLE     �   CREATE TABLE public.sensor_data (
    sensor_data_id integer NOT NULL,
    sensor_id integer NOT NULL,
    sensor_value character varying NOT NULL,
    sensor_value_date timestamp without time zone NOT NULL
);
    DROP TABLE public.sensor_data;
       public            postgres    false            �            1259    65554    sensor_data_sensor_data_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sensor_data_sensor_data_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.sensor_data_sensor_data_id_seq;
       public          postgres    false    213            �           0    0    sensor_data_sensor_data_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.sensor_data_sensor_data_id_seq OWNED BY public.sensor_data.sensor_data_id;
          public          postgres    false    212            �            1259    49215     sensor_types_sensor_types_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sensor_types_sensor_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 7   DROP SEQUENCE public.sensor_types_sensor_types_id_seq;
       public          postgres    false            �            1259    41024    sensor_types    TABLE     �   CREATE TABLE public.sensor_types (
    sensor_type_id integer DEFAULT nextval('public.sensor_types_sensor_types_id_seq'::regclass) NOT NULL,
    sensor_type character varying NOT NULL,
    data_type character varying NOT NULL
);
     DROP TABLE public.sensor_types;
       public            postgres    false    207            �            1259    41013    sensors    TABLE     |   CREATE TABLE public.sensors (
    sensor_type_id integer NOT NULL,
    sensor_id integer NOT NULL,
    device_id integer
);
    DROP TABLE public.sensors;
       public            postgres    false            �            1259    49187    sensors_sensor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sensors_sensor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.sensors_sensor_id_seq;
       public          postgres    false    202            �           0    0    sensors_sensor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.sensors_sensor_id_seq OWNED BY public.sensors.sensor_id;
          public          postgres    false    205            �            1259    49217    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false            �            1259    40969    users    TABLE     I  CREATE TABLE public.users (
    user_id integer DEFAULT nextval('public.users_user_id_seq'::regclass) NOT NULL,
    user_full_name character varying NOT NULL,
    user_login character varying NOT NULL,
    user_pass character varying NOT NULL,
    user_create_date timestamp without time zone,
    user_admin boolean NOT NULL
);
    DROP TABLE public.users;
       public            postgres    false    208            �            1259    49219    valves_valve_id_seq    SEQUENCE     �   CREATE SEQUENCE public.valves_valve_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 *   DROP SEQUENCE public.valves_valve_id_seq;
       public          postgres    false            �            1259    40991    valves    TABLE     �  CREATE TABLE public.valves (
    valve_id integer DEFAULT nextval('public.valves_valve_id_seq'::regclass) NOT NULL,
    valve_name character varying NOT NULL,
    valve_failed_operation boolean,
    valve_failed_endpoint character varying,
    valve_running boolean,
    valve_failed_counter integer,
    valve_on_endpoint character varying,
    valve_off_endpoint character varying
);
    DROP TABLE public.valves;
       public            postgres    false    209            �            1259    65539    watering_hours    TABLE     �   CREATE TABLE public.watering_hours (
    watering_hours_id integer NOT NULL,
    "time" character varying NOT NULL,
    configuration_id integer NOT NULL
);
 "   DROP TABLE public.watering_hours;
       public            postgres    false            �           0    0    TABLE watering_hours    COMMENT     C   COMMENT ON TABLE public.watering_hours IS '6:30, 7:00, 7:30, ...';
          public          postgres    false    211            �            1259    65537 $   watering_hours_watering_hours_id_seq    SEQUENCE     �   CREATE SEQUENCE public.watering_hours_watering_hours_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.watering_hours_watering_hours_id_seq;
       public          postgres    false    211            �           0    0 $   watering_hours_watering_hours_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.watering_hours_watering_hours_id_seq OWNED BY public.watering_hours.watering_hours_id;
          public          postgres    false    210                       2604    49165    configurations configuration_id    DEFAULT     �   ALTER TABLE ONLY public.configurations ALTER COLUMN configuration_id SET DEFAULT nextval('public.configurations_configuration_id_seq'::regclass);
 N   ALTER TABLE public.configurations ALTER COLUMN configuration_id DROP DEFAULT;
       public          postgres    false    204    199                       2604    49199    devices device_id    DEFAULT     v   ALTER TABLE ONLY public.devices ALTER COLUMN device_id SET DEFAULT nextval('public.devices_device_id_seq'::regclass);
 @   ALTER TABLE public.devices ALTER COLUMN device_id DROP DEFAULT;
       public          postgres    false    206    201                       2604    65559    sensor_data sensor_data_id    DEFAULT     �   ALTER TABLE ONLY public.sensor_data ALTER COLUMN sensor_data_id SET DEFAULT nextval('public.sensor_data_sensor_data_id_seq'::regclass);
 I   ALTER TABLE public.sensor_data ALTER COLUMN sensor_data_id DROP DEFAULT;
       public          postgres    false    212    213    213                       2604    49189    sensors sensor_id    DEFAULT     v   ALTER TABLE ONLY public.sensors ALTER COLUMN sensor_id SET DEFAULT nextval('public.sensors_sensor_id_seq'::regclass);
 @   ALTER TABLE public.sensors ALTER COLUMN sensor_id DROP DEFAULT;
       public          postgres    false    205    202                       2604    65542     watering_hours watering_hours_id    DEFAULT     �   ALTER TABLE ONLY public.watering_hours ALTER COLUMN watering_hours_id SET DEFAULT nextval('public.watering_hours_watering_hours_id_seq'::regclass);
 O   ALTER TABLE public.watering_hours ALTER COLUMN watering_hours_id DROP DEFAULT;
       public          postgres    false    210    211    211            �          0    40983    configurations 
   TABLE DATA           �   COPY public.configurations (active_time, configuration_changed_by, valve_id, configuration_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday, watering_active_counter) FROM stdin;
    public          postgres    false    199   s\       �          0    41005    devices 
   TABLE DATA           d   COPY public.devices (device_name, device_location, device_id, user_id, device_endpoint) FROM stdin;
    public          postgres    false    201   �\       �          0    40961    logs 
   TABLE DATA           U   COPY public.logs (log_date, log_description, log_level, user_id, log_id) FROM stdin;
    public          postgres    false    197   ]       �          0    65556    sensor_data 
   TABLE DATA           a   COPY public.sensor_data (sensor_data_id, sensor_id, sensor_value, sensor_value_date) FROM stdin;
    public          postgres    false    213   q]       �          0    41024    sensor_types 
   TABLE DATA           N   COPY public.sensor_types (sensor_type_id, sensor_type, data_type) FROM stdin;
    public          postgres    false    203   �d       �          0    41013    sensors 
   TABLE DATA           G   COPY public.sensors (sensor_type_id, sensor_id, device_id) FROM stdin;
    public          postgres    false    202   �d       �          0    40969    users 
   TABLE DATA           m   COPY public.users (user_id, user_full_name, user_login, user_pass, user_create_date, user_admin) FROM stdin;
    public          postgres    false    198   $e       �          0    40991    valves 
   TABLE DATA           �   COPY public.valves (valve_id, valve_name, valve_failed_operation, valve_failed_endpoint, valve_running, valve_failed_counter, valve_on_endpoint, valve_off_endpoint) FROM stdin;
    public          postgres    false    200   Ve       �          0    65539    watering_hours 
   TABLE DATA           U   COPY public.watering_hours (watering_hours_id, "time", configuration_id) FROM stdin;
    public          postgres    false    211   �e       �           0    0 #   configurations_configuration_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.configurations_configuration_id_seq', 3, true);
          public          postgres    false    204            �           0    0    devices_device_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.devices_device_id_seq', 2, true);
          public          postgres    false    206            �           0    0    logs_log_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.logs_log_id_seq', 1, false);
          public          postgres    false    196            �           0    0    sensor_data_sensor_data_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.sensor_data_sensor_data_id_seq', 312, true);
          public          postgres    false    212            �           0    0     sensor_types_sensor_types_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.sensor_types_sensor_types_id_seq', 5, true);
          public          postgres    false    207            �           0    0    sensors_sensor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.sensors_sensor_id_seq', 5, true);
          public          postgres    false    205            �           0    0    users_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.users_user_id_seq', 2, true);
          public          postgres    false    208            �           0    0    valves_valve_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.valves_valve_id_seq', 1, false);
          public          postgres    false    209            �           0    0 $   watering_hours_watering_hours_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.watering_hours_watering_hours_id_seq', 1, false);
          public          postgres    false    210                       2606    49174 "   configurations configurations_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.configurations
    ADD CONSTRAINT configurations_pkey PRIMARY KEY (configuration_id);
 L   ALTER TABLE ONLY public.configurations DROP CONSTRAINT configurations_pkey;
       public            postgres    false    199            #           2606    49207    devices devices_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_pkey PRIMARY KEY (device_id);
 >   ALTER TABLE ONLY public.devices DROP CONSTRAINT devices_pkey;
       public            postgres    false    201                       2606    49186    logs logs_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.logs
    ADD CONSTRAINT logs_pkey PRIMARY KEY (log_id);
 8   ALTER TABLE ONLY public.logs DROP CONSTRAINT logs_pkey;
       public            postgres    false    197            0           2606    65564    sensor_data sensor_data_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.sensor_data
    ADD CONSTRAINT sensor_data_pkey PRIMARY KEY (sensor_data_id);
 F   ALTER TABLE ONLY public.sensor_data DROP CONSTRAINT sensor_data_pkey;
       public            postgres    false    213            *           2606    41031    sensor_types sensor_types_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.sensor_types
    ADD CONSTRAINT sensor_types_pkey PRIMARY KEY (sensor_type_id);
 H   ALTER TABLE ONLY public.sensor_types DROP CONSTRAINT sensor_types_pkey;
       public            postgres    false    203            (           2606    49196    sensors sensors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.sensors
    ADD CONSTRAINT sensors_pkey PRIMARY KEY (sensor_id);
 >   ALTER TABLE ONLY public.sensors DROP CONSTRAINT sensors_pkey;
       public            postgres    false    202                       2606    40976    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    198            !           2606    40998    valves valves_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.valves
    ADD CONSTRAINT valves_pkey PRIMARY KEY (valve_id);
 <   ALTER TABLE ONLY public.valves DROP CONSTRAINT valves_pkey;
       public            postgres    false    200            -           2606    65544 "   watering_hours watering_hours_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.watering_hours
    ADD CONSTRAINT watering_hours_pkey PRIMARY KEY (watering_hours_id);
 L   ALTER TABLE ONLY public.watering_hours DROP CONSTRAINT watering_hours_pkey;
       public            postgres    false    211                       1259    41004 "   fki_configurations_valves_valve_id    INDEX     a   CREATE INDEX fki_configurations_valves_valve_id ON public.configurations USING btree (valve_id);
 6   DROP INDEX public.fki_configurations_valves_valve_id;
       public            postgres    false    199            $           1259    49231    fki_devices_users_user_id    INDEX     P   CREATE INDEX fki_devices_users_user_id ON public.devices USING btree (user_id);
 -   DROP INDEX public.fki_devices_users_user_id;
       public            postgres    false    201                       1259    40982    fki_logs_users_user_id    INDEX     J   CREATE INDEX fki_logs_users_user_id ON public.logs USING btree (user_id);
 *   DROP INDEX public.fki_logs_users_user_id;
       public            postgres    false    197            .           1259    65570 !   fki_sensor_data_sensors_sensor_id    INDEX     ^   CREATE INDEX fki_sensor_data_sensors_sensor_id ON public.sensor_data USING btree (sensor_id);
 5   DROP INDEX public.fki_sensor_data_sensors_sensor_id;
       public            postgres    false    213            %           1259    49213    fki_sensors_devices_device_id    INDEX     V   CREATE INDEX fki_sensors_devices_device_id ON public.sensors USING btree (device_id);
 1   DROP INDEX public.fki_sensors_devices_device_id;
       public            postgres    false    202            &           1259    41051 '   fki_sensors_sensor_types_sensor_type_id    INDEX     e   CREATE INDEX fki_sensors_sensor_types_sensor_type_id ON public.sensors USING btree (sensor_type_id);
 ;   DROP INDEX public.fki_sensors_sensor_types_sensor_type_id;
       public            postgres    false    202            +           1259    65553 1   fki_watering_hours_configuration_configuration_id    INDEX     x   CREATE INDEX fki_watering_hours_configuration_configuration_id ON public.watering_hours USING btree (configuration_id);
 E   DROP INDEX public.fki_watering_hours_configuration_configuration_id;
       public            postgres    false    211            2           2606    40999 -   configurations configurations_valves_valve_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.configurations
    ADD CONSTRAINT configurations_valves_valve_id FOREIGN KEY (valve_id) REFERENCES public.valves(valve_id) NOT VALID;
 W   ALTER TABLE ONLY public.configurations DROP CONSTRAINT configurations_valves_valve_id;
       public          postgres    false    2849    200    199            3           2606    49226    devices devices_users_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_users_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id) NOT VALID;
 G   ALTER TABLE ONLY public.devices DROP CONSTRAINT devices_users_user_id;
       public          postgres    false    201    198    2844            1           2606    40977    logs logs_users_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.logs
    ADD CONSTRAINT logs_users_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id) NOT VALID;
 A   ALTER TABLE ONLY public.logs DROP CONSTRAINT logs_users_user_id;
       public          postgres    false    197    2844    198            7           2606    65565 )   sensor_data sensor_data_sensors_sensor_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.sensor_data
    ADD CONSTRAINT sensor_data_sensors_sensor_id FOREIGN KEY (sensor_id) REFERENCES public.sensors(sensor_id) NOT VALID;
 S   ALTER TABLE ONLY public.sensor_data DROP CONSTRAINT sensor_data_sensors_sensor_id;
       public          postgres    false    2856    213    202            5           2606    49208 !   sensors sensors_devices_device_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.sensors
    ADD CONSTRAINT sensors_devices_device_id FOREIGN KEY (device_id) REFERENCES public.devices(device_id) NOT VALID;
 K   ALTER TABLE ONLY public.sensors DROP CONSTRAINT sensors_devices_device_id;
       public          postgres    false    2851    201    202            4           2606    41046 +   sensors sensors_sensor_types_sensor_type_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.sensors
    ADD CONSTRAINT sensors_sensor_types_sensor_type_id FOREIGN KEY (sensor_type_id) REFERENCES public.sensor_types(sensor_type_id) NOT VALID;
 U   ALTER TABLE ONLY public.sensors DROP CONSTRAINT sensors_sensor_types_sensor_type_id;
       public          postgres    false    2858    202    203            6           2606    65548 <   watering_hours watering_hours_configuration_configuration_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.watering_hours
    ADD CONSTRAINT watering_hours_configuration_configuration_id FOREIGN KEY (configuration_id) REFERENCES public.configurations(configuration_id) NOT VALID;
 f   ALTER TABLE ONLY public.watering_hours DROP CONSTRAINT watering_hours_configuration_configuration_id;
       public          postgres    false    2846    199    211            �   &   x�33�4B#�?��������3	Zr��qqq �X/      �   N   x����Q����,�/�LO,JI�S�U(�L�(Q(�LI�4��+}}CK#=C3=C=CS�����ĒD�=... K��      �   Z   x�3202�54�5�P00�#��Ģ�̼t��<��Ĝ�T�r� �!��������!4��!����@�� ���@L	*6����� ��%      �     x�}�[��*E��Q�:��������"H�֩U��ـ�A�S~��k�P&���/�����wN�3�^^�����ګށ��󿍖46|�W3�W�@ۆ�l�$���>�A!P2Pt#�TJ�8 �bL0��EhKEb��$��1Q�ۡ�~�QRi���$��$�[&�X�b���]�M����;R�F�%��D�7o��7-Bq$�L��߼�z.�t+�N#DZ���?�8@�yt��w�o	�	+�W��F��w��V(
X)~��\S�8 Ǉ��$b��Xc�*��m��3t#q�%[� !H�"x�Z�%�-yl�C0��EhO"�� V�2��H�2�SZ,9@ߒ�m=�*wy�uA��5ǒ 9�΋����C��=4�P�)kIg�iE���=��6vD����5���hRW�W��w�<��M����T	i�*�<5��������Z$UE����nUG4���0��i�i2���2�73��4J-�~о3�u?ħ�D}�RמZ\��x3;�S��kFP�=�;з�1�["w��4ۯ��P���A�9�I��:ǎ�u�y��O/�k���p���[|r}��8W�lM}Ă/0r|n9�l�}�� 
��h�� ���� �u���������rDے�\e�F����-��n�(9��qk�}�����������PW�ZP��h��Ƈ�G*�b-��x2�g��,�Rr�9�����#>�c�b��-��q�F��Ϋr��D�ڿ-�\�O���['%�(oK�D�U����Dp%h"���<��m�R�J|b��<xd!}�+EAp%��A8�b=N�(	���8���"bC���J|�`��T�i�DIp%:��C�tC�T�(
�D�q�XKkD�`}�Ͽ�$�Q�G�a!qx���t�)k$Ր8
�xR���Pf�V4O0�8D�gձ��O4OT�qH�O�P�0��؞����gv��%ݞ��a�	�qO5�e�y����=�R��-d�P�0�D��<�m_��=[�����Cxƛu--NO��C@�*ebJ�� y���KyVr��� =ǳq�u\�>�qx��G@Ъ�j���0��|���I��m(qxb �AF=H� p{֡�<���'xR�|֡>�q"qx��us� �u�{���0�D�q��7�qxB�N�#{8�hzi���a��{<ҁ�"cn�:K�~�qAJ"� "CX�D��@����sq�%�s;y��=�G@{�r����� �B�=`�q�*�&= �}˾" ��Ph~#��^	���\�p[S�';Q����#�+���{��'�W�DO[�hx"�L$NO�?����8<�����ȪeeC�������R�K+q��	���# �S�s�H�!x���8t�KYm�q���<Q�!��)�Y�w� �qO�S���q��	��AV)�R�'z\���R�3�j�!x�G@� ����[X�<�� �C@�����!qx<H��'�M��R����8�r�o��'x"`>��Ŏ��'j|�y���)�D�<�� �9H���JY��}���!�k�+�@�jYh�X��
<�������':�A����e#�`9�E[�\��qxB��!y��L����'J�+�����i@�N���5*#JOp����i@�R�
��D�4�awpE�4 {)�"�H�W"��H����"Q\��;� %��^
��J�H�\	��E�{�����d      �   H   x�3�I�-H-J,)-J�L��O,�2�������+�2��(��L�,��ʙp:f)�#4�������� fOK      �   !   x�3�4���2�B.#N# i�i$c���� A5�      �   "   x�3��,K����̄P�F�&�1~�%\1z\\\ �V�      �   K   x�3��M��S(K�)K�L��,�4��())���7�4�34��3�34��OεO��K��/O-R��#J��W� ��      �   #   x�3�4�26�4�2�44�2 ��9�!b1z\\\ Zn�     