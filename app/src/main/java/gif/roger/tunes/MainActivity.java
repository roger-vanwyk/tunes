package gif.roger.tunes;

import android.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.*;
import com.bumptech.glide.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.text.*;
import java.util.*;

import android.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private double play = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private double n = 0;
	private String songId = "";
	private String Artist = "";
	private String Title = "";
	private String Data = "";
	private String displayName = "";
	private String Duration = "";
	private String Album = "";
	private String image = "";
	private String decodestring = "";
	private String albumArt = "";
	private double m = 0;
	private HashMap<String, Object> mapvar = new HashMap<>();
	private double exist = 0;
	private String name = "";
	private String imgPath = "";
	private double expand = 0;
	private String currentfile = "";
	private double songPosition = 0;
	private double fav = 0;
	private String songFav = "";
	private String folderName = "";
	private String item_ = "";
	private double wh_ = 0;
	private String allSongsJson = "";
	private double length = 0;
	private double r = 0;
	private String value1 = "";
	private String text = "";
	private double color = 0;
	private double filterFav = 0;
	private double seeking = 0;
	private double volumeLevel = 0;
	private double rotation = 0;
	private double nnrrr = 0;
	
	private ArrayList<String> songlist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> songmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> art = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> artNew = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> favoriteMap = new ArrayList<>();
	private ArrayList<String> sortlist = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear14;
	private ListView listview1;
	private ProgressBar progressbar1;
	private LinearLayout linear4play;
	private LinearLayout linear17;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear6bar;
	private ProgressBar progressbar2;
	private LinearLayout linear5;
	private LinearLayout linear3;
	private TextView textview1;
	private TextView textview2;
	private ImageView imageview1;
	private LinearLayout linear16;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private LinearLayout linear6;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private SeekBar seekbar2;
	private ImageView imageview5;
	private ImageView imageview11;
	private LinearLayout linear12;
	private LinearLayout linear7;
	private TextView textview3;
	private TextView textview4;
	private TextView textview7;
	private TextView textview5;
	private SeekBar seekbar1;
	private TextView textview6;
	private LinearLayout linear8;
	private ImageView imageview6ordrer;
	private ImageView imageview7pre;
	private ImageView imageview8play;
	private ImageView imageview9next;
	private ImageView imageview10fav;
	private TextView textview9;
	private Button button1;
	
	private MediaPlayer mp;
	private TimerTask t;
	private Intent i = new Intent();
	private TimerTask timer;
	private TimerTask playTimer;
	private TimerTask end;
	private TimerTask newtimer;
	private SharedPreferences file;
	private AlertDialog.Builder d;
	private TimerTask vol;
	private TimerTask rotation_time;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		listview1 = (ListView) findViewById(R.id.listview1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear4play = (LinearLayout) findViewById(R.id.linear4play);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear6bar = (LinearLayout) findViewById(R.id.linear6bar);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		seekbar2 = (SeekBar) findViewById(R.id.seekbar2);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview5 = (TextView) findViewById(R.id.textview5);
		seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		imageview6ordrer = (ImageView) findViewById(R.id.imageview6ordrer);
		imageview7pre = (ImageView) findViewById(R.id.imageview7pre);
		imageview8play = (ImageView) findViewById(R.id.imageview8play);
		imageview9next = (ImageView) findViewById(R.id.imageview9next);
		imageview10fav = (ImageView) findViewById(R.id.imageview10fav);
		textview9 = (TextView) findViewById(R.id.textview9);
		button1 = (Button) findViewById(R.id.button1);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				_getSong(_position);
				linear6bar.setVisibility(View.VISIBLE);
				if (songPosition == -1) {
					_CreateMedia(_position);
					_MediaStart();
				}
				else {
					if (_position == songPosition) {
						if (mp.isPlaying()) {
							listview1.setVisibility(View.GONE);
							linear4play.setVisibility(View.GONE);
							linear6.setVisibility(View.VISIBLE);
							expand = 1;
						}
						else {
							_MediaStart();
						}
					}
					else {
						if (mp.isPlaying()) {
							_MediaPause();
						}
						mp.reset();
						mp.release();
						_CreateMedia(_position);
						_MediaStart();
					}
				}
				playTimer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								nnrrr++;
								imageview1.setRotation((float)(nnrrr));
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(playTimer, (int)(30), (int)(30));
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				listview1.setVisibility(View.GONE);
				linear4play.setVisibility(View.GONE);
				linear6.setVisibility(View.VISIBLE);
				expand = 1;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playPre();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
					linear6bar.setVisibility(View.GONE);
				}
				else {
					_MediaStart();
					linear6bar.setVisibility(View.VISIBLE);
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playNext();
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				seekbar2.setVisibility(View.VISIBLE);
				_volume();
			}
		});
		
		seekbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, _progressValue, 0);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				seeking = 1;
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								seeking = 0;
							}
						});
					}
				};
				_timer.schedule(t, (int)(2000));
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				if (!(songPosition == -1)) {
					mp.seekTo((int)(seekbar1.getProgress()));
				}
			}
		});
		
		imageview6ordrer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (file.getString("order", "").equals("order")) {
					file.edit().putString("order", "repeat").commit();
					imageview6ordrer.setImageResource(R.drawable.exo_controls_repeat_one);
					QueryUtil.showMessage(getApplicationContext(), "Repeat current song");
				}
				else {
					if (file.getString("order", "").equals("repeat")) {
						file.edit().putString("order", "shuffle").commit();
						imageview6ordrer.setImageResource(R.drawable.exo_controls_shuffle);
						QueryUtil.showMessage(getApplicationContext(), "Shuffle");
					}
					else {
						file.edit().putString("order", "order").commit();
						imageview6ordrer.setImageResource(R.drawable.ic_my_library_music_white);
						QueryUtil.showMessage(getApplicationContext(), "Play in order");
					}
				}
			}
		});
		
		imageview7pre.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playPre();
			}
		});
		
		imageview8play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
					linear6bar.setVisibility(View.GONE);
				}
				else {
					_MediaStart();
					linear6bar.setVisibility(View.VISIBLE);
				}
			}
		});
		
		imageview9next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playNext();
			}
		});
		
		imageview10fav.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (songmap.get((int)songPosition).containsKey("favorite")) {
					if (songmap.get((int)songPosition).get("favorite").toString().equals("true")) {
						songmap.get((int)songPosition).put("favorite", "false");
					}
					else {
						songmap.get((int)songPosition).put("favorite", "true");
					}
				}
				else {
					songmap.get((int)songPosition).put("favorite", "true");
				}
				allSongsJson = new Gson().toJson(songmap);
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				_isFavourite(songPosition);
				_setFavorite(songPosition);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				openSettings();
			}
		});
	}
	private void initializeLogic() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		
		com.google.android.material.appbar.AppBarLayout appBarLayout = (com.google.android.material.appbar.AppBarLayout) _toolbar.getParent(); appBarLayout.setStateListAnimator(null);
		progressbar2.getProgressDrawable().setColorFilter(Color.parseColor("#ffffff"), android.graphics.PorterDuff.Mode.SRC_IN);
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		seekbar2.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
		seekbar2.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		i.setClass(getApplicationContext(), SplashActivity.class);
		startActivity(i);
		textview1.setSingleLine(true);
		textview1.setEllipsize(TextUtils.TruncateAt.END);
		textview2.setSingleLine(true);
		textview2.setEllipsize(TextUtils.TruncateAt.END);
		textview3.setSingleLine(true);
		textview3.setEllipsize(TextUtils.TruncateAt.END);
		textview4.setSingleLine(true);
		textview4.setEllipsize(TextUtils.TruncateAt.END);
		seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		seekbar2.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		seekbar2.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		if (!file.getString("favorite", "").equals("")) {
			favoriteMap = new Gson().fromJson(file.getString("favorite", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (file.getString("order", "").equals("")) {
			file.edit().putString("order", "order").commit();
		}
		seeking = 0;
		filterFav = 0;
		item_ = "";
		play = 0;
		n = 0;
		m = 0;
		expand = 0;
		songPosition = -1;
		listview1.setAdapter(new Listview1Adapter(songmap));
		linear6bar.setVisibility(View.GONE);
		progressbar1.setVisibility(View.GONE);
		linear4play.setVisibility(View.VISIBLE);
		linear6.setVisibility(View.GONE);
		seekbar2.setVisibility(View.INVISIBLE);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_create();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(200));
		sortlist.add("Name");
		sortlist.add("Artist");
		sortlist.add("Favorite");
		sortlist.add("Descending");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (expand == 0) {
			finish();
		}
		else {
			listview1.setVisibility(View.VISIBLE);
			linear6.setVisibility(View.GONE);
			linear4play.setVisibility(View.VISIBLE);
			expand = 0;
		}
	}
	private void _getSong (final double _pos) {
		if (expand == 1) {
			linear4play.setVisibility(View.GONE);
		}
		else {
			linear4play.setVisibility(View.VISIBLE);
		}
		textview1.setText(songmap.get((int)_pos).get("title").toString());
		textview2.setText(songmap.get((int)_pos).get("artist").toString());
		textview3.setText(songmap.get((int)_pos).get("title").toString());
		textview4.setText(songmap.get((int)_pos).get("artist").toString());
		textview7.setText(songmap.get((int)_pos).get("folder").toString());
		currentfile = songmap.get((int)_pos).get("data").toString();
		name = songmap.get((int)_pos).get("artist").toString().toLowerCase();
		m = 0;
		for(int _repeat18 = 0; _repeat18 < (int)(artNew.size()); _repeat18++) {
			if (name.equals(artNew.get((int)m).get("artist").toString().toLowerCase())) {
				if (artNew.get((int)m).containsKey("albumArt")) {
					
					imgPath = artNew.get((int)m).get("albumArt").toString();
					Glide.with(getApplicationContext())
					        .asBitmap()
					        .load(imgPath)
					        .into(new com.bumptech.glide.request.target.BitmapImageViewTarget(imageview1) {
						@Override
						protected void setResource(Bitmap resource) {
							androidx.core.graphics.drawable.RoundedBitmapDrawable drawable = androidx.core.graphics.drawable.RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(),Bitmap.createScaledBitmap(resource, 500, 500, false));
							drawable.setCircular(true);
							imageview1.setImageDrawable(drawable);
						}
					});
					imageview5.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(artNew.get((int)m).get("albumArt").toString(), 1024, 1024));
					imageview11.setVisibility(View.GONE);
					imageview5.setVisibility(View.VISIBLE);
				}
				else {
					imageview1.setImageResource(R.drawable.jsjs);
					imageview5.setImageResource(R.drawable.ic_recm_default_exclusive_bg);
					imageview11.setVisibility(View.VISIBLE);
					imageview5.setVisibility(View.GONE);
				}
				break;
			}
			else {
				imageview1.setImageResource(R.drawable.ic_music_blue);
				imageview5.setImageResource(R.drawable.ic_recm_default_exclusive_bg);
				imageview11.setVisibility(View.VISIBLE);
				imageview5.setVisibility(View.GONE);
			}
			m++;
		}
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						bitmap = ((android.graphics.drawable.BitmapDrawable) imageview5.getDrawable()).getBitmap();
						color = getDominantColor1(bitmap);
						if (getSupportActionBar() != null) {
							    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
							    getSupportActionBar().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(manipulateColor(getDominantColor1(bitmap), 0.32f)));
							
							getWindow().setStatusBarColor(manipulateColor(getDominantColor1(bitmap), 0.32f));
						}
						linear1.setBackgroundColor(manipulateColor(getDominantColor1(bitmap), 0.32f));
						linear4play.setBackgroundColor(manipulateColor(getDominantColor1(bitmap), 0.50f));
					}
				});
			}
		};
		_timer.schedule(t, (int)(100));
	}
	
	
	private void _Library () {
	}
	private Bitmap bitmap;
	{
	}
	private void openSettings() {
		    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		    Uri uri = Uri.fromParts("package", getPackageName(), null);
		    intent.setData(uri);
		    startActivityForResult(intent, 101);
	}
	{
	}
	AudioManager audioManager;
	{
	}
	
	
	private void _extra () {
	}
	public static int manipulateColor(int color, float factor) {
		    int a = Color.alpha(color);
		    int r = Math.round(Color.red(color) * factor);
		    int g = Math.round(Color.green(color) * factor);
		    int b = Math.round(Color.blue(color) * factor);
		    return Color.argb(a,
		            Math.min(r, 255),
		            Math.min(g, 255),
		            Math.min(b, 255));
	}
	{
	}
	public static int getDominantColor1(Bitmap bitmap) {
		 try{
			    Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
			    final int color = newBitmap.getPixel(0, 0);
			    newBitmap.recycle();
			    return color;
		}catch (Exception e){
			return -11508009;
		}
	}
	{
	}
	
	
	private void _getAllSong () {
		String selection = android.provider.MediaStore.Audio.Media.IS_MUSIC + " != 0";
		
		String[] projection = {
			    android.provider.MediaStore.Audio.Media._ID,
			    android.provider.MediaStore.Audio.Media.ARTIST,
			    android.provider.MediaStore.Audio.Media.TITLE,
			    android.provider.MediaStore.Audio.Media.DATA,
			    android.provider.MediaStore.Audio.Media.DISPLAY_NAME,
			    android.provider.MediaStore.Audio.Media.DURATION
			
		};
		
		android.database.Cursor cursor = this.managedQuery(
		    android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
		
		while(cursor.moveToNext()) {
			     songId = cursor.getString(0);
			     Artist = cursor.getString(1);
			     Title = cursor.getString(2);
			     Data = cursor.getString(3);
			     displayName = cursor.getString(4);
			     Duration = cursor.getString(5);
			
			map = new HashMap<>();
			map.put("id", songId);
			map.put("artist", Artist);
			map.put("title", Title);
			map.put("data", Data);
			map.put("displayName", displayName);
			map.put("duration", Duration);
			java.io.File file = new java.io.File(Data); 
			folderName = file.getParentFile().getName();
			map.put("folder", folderName);
			fav = 0;
			for(int _repeat27 = 0; _repeat27 < (int)(favoriteMap.size()); _repeat27++) {
				if (songId.equals(favoriteMap.get((int)fav).get("id").toString())) {
					map.put("favorite", "true");
				}
				fav++;
			}
			songmap.add(map);
		}
	}
	
	
	private void _getArts () {
		String[] projection1 = {
			    android.provider.MediaStore.Audio.Albums.ARTIST,
			    android.provider.MediaStore.Audio.Albums.ALBUM,
			    android.provider.MediaStore.Audio.Albums.ALBUM_ART
			
		};
		
		final Uri uri = android.provider.MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
		
		 android.database.Cursor cursor1 = getContentResolver().query(uri, projection1, null, null, null);
		
		while (cursor1.moveToNext()) {
			Artist = cursor1.getString(0);
			Album = cursor1.getString(1);
			albumArt = cursor1.getString(2);
			mapvar = new HashMap<>();
			mapvar.put("artist", Artist);
			mapvar.put("album", Album);
			mapvar.put("albumArt", albumArt);
			art.add(mapvar);
		}
		artNew = new Gson().fromJson(new Gson().toJson(art), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
	}
	
	
	private void _create () {
		if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {

			linear1.setVisibility(View.GONE);
			linear14.setVisibility(View.VISIBLE);
		}else{

			timer.cancel();
			_getAllSong();
			_getArts();
			allSongsJson = new Gson().toJson(songmap);
			_SortMap(songmap, "title", false, true);
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			linear1.setVisibility(View.VISIBLE);
			linear14.setVisibility(View.GONE);
			_getSong(0);
			_CreateMedia(0);
		}
	}
	
	
	private void _CreateMedia (final double _pos) {
		currentfile = songmap.get((int)_pos).get("data").toString();
		songPosition = _pos;
		mp = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new java.io.File(currentfile)));
		progressbar2.setMax((int)mp.getDuration());
		seekbar1.setMax((int)mp.getDuration());
		int dur = (int) mp.getDuration();
		
		int mns = (dur / 60000) % 60000;
		int scs = dur % 60000 / 1000;
		
		NumberFormat formatter = new DecimalFormat("00");
		String seconds = formatter.format(scs);
		
		String songTime = String.format("%02d:%02d", mns,  scs);
		textview6.setText(songTime);
		_isFavourite(_pos);
	}
	
	
	private void _MediaStart () {
		mp.start();
		imageview3.setImageResource(R.drawable.exo_controls_pause);
		imageview8play.setImageResource(R.drawable.exo_controls_pause);
		playTimer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						try{
							progressbar2.setProgress((int)mp.getCurrentPosition());
							seekbar1.setProgress((int)mp.getCurrentPosition());
							int dur = (int) mp.getCurrentPosition();
							
							int mns = (dur / 60000) % 60000;
							int scs = dur % 60000 / 1000;
							
							NumberFormat formatter = new DecimalFormat("00");
							String seconds = formatter.format(scs);
							
							String currentTime = String.format("%02d:%02d", mns,  scs);
							textview5.setText(currentTime);
						}catch(Exception e){
							playTimer.cancel();
							QueryUtil.showMessage(getApplicationContext(), "Action failed");
							i.setClass(getApplicationContext(), MainActivity.class);
							startActivity(i);
							finish();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(playTimer, (int)(400), (int)(400));
		mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			                    @Override
			                    public void onCompletion(MediaPlayer mediaPlayer) {
				_songEnd();
			}
			                });
		rotation = 0;
		rotation_time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						rotation++;
						imageview11.setRotation((float)(rotation));
						imageview1.setRotation((float)(rotation));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(rotation_time, (int)(0), (int)(40));
	}
	
	
	private void _MediaPause () {
		playTimer.cancel();
		mp.pause();
		imageview3.setImageResource(R.drawable.exo_controls_play);
		imageview8play.setImageResource(R.drawable.exo_controls_play);
		rotation_time.cancel();
		rotation = 0;
	}
	
	
	private void _playNext () {
		if (songPosition == (songmap.size() - 1)) {
			_getSong(0);
			_CreateMedia(0);
			_MediaStart();
		}
		else {
			_getSong(songPosition + 1);
			_CreateMedia(songPosition + 1);
			_MediaStart();
		}
	}
	
	
	private void _playPre () {
		if (songPosition == 0) {
			_getSong(songmap.size() - 1);
			_CreateMedia(songmap.size() - 1);
			_MediaStart();
		}
		else {
			_getSong(songPosition - 1);
			_CreateMedia(songPosition - 1);
			_MediaStart();
		}
	}
	
	
	private void _favorite () {
		
	}
	
	
	private void _songEnd () {
		if (file.getString("order", "").equals("order")) {
			if (songPosition == (songmap.size() - 1)) {
				_getSong(0);
				_CreateMedia(0);
				_MediaStart();
			}
			else {
				_getSong(songPosition + 1);
				_CreateMedia(songPosition + 1);
				_MediaStart();
			}
		}
		else {
			if (file.getString("order", "").equals("repeat")) {
				_getSong(songPosition);
				_CreateMedia(songPosition);
				_MediaStart();
			}
			else {
				songPosition = QueryUtil.getRandom((int)(0), (int)(songmap.size()));
				_getSong(songPosition);
				_CreateMedia(songPosition);
				_MediaStart();
			}
		}
	}
	
	
	private void _isFavourite (final double _pos) {
		if (songmap.get((int)_pos).containsKey("favorite")) {
			if (songmap.get((int)_pos).get("favorite").toString().equals("true")) {
				imageview10fav.setImageResource(R.drawable.ic_heart_fill);
			}
			else {
				imageview10fav.setImageResource(R.drawable.ic_heart_empty);
			}
		}
		else {
			imageview10fav.setImageResource(R.drawable.ic_heart_empty);
		}
	}
	
	
	private void _SortMap (final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					}
					else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				}
				else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					}
					else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
	}
	
	
	private void _setFavorite (final double _pos) {
		fav = 0;
		if (!(favoriteMap.size() == 0)) {
			for(int _repeat10 = 0; _repeat10 < (int)(favoriteMap.size()); _repeat10++) {
				if (favoriteMap.get((int)fav).get("id").toString().equals(songmap.get((int)_pos).get("id").toString())) {
					songFav = "true";
					break;
				}
				else {
					songFav = "false";
				}
				fav++;
			}
		}
		else {
			songFav = "false";
		}
		if (songFav.equals("false")) {
			mapvar = songmap.get((int)_pos);
			favoriteMap.add(mapvar);
		}
		else {
			favoriteMap.remove((int)(fav));
		}
		file.edit().putString("favorite", new Gson().toJson(favoriteMap)).commit();
	}
	
	
	private void _option_menu () {
	}
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(0,0,0, "Favorite").setIcon(R.drawable.ic_filter_list_white).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add(0,1,1, "Favorite").setIcon(R.drawable.ic_refresh).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	 @Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case 0:
			_move1();
			break;
			case 1:
			_move2();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private void _move1 () {
		d.setTitle("Sort by");
		_Single_Choice_Dialog(d, sortlist);
		d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				try{
					if (!item_.equals("")) {
						if (!allSongsJson.equals("")) {
							songmap = new Gson().fromJson(allSongsJson, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							if (item_.equals("Name")) {
								_SortMap(songmap, "title", false, true);
								filterFav = 0;
							}
							else {
								if (item_.equals("Artist")) {
									_SortMap(songmap, "artist", false, true);
									filterFav = 0;
								}
								else {
									if (item_.equals("Descending")) {
										_SortMap(songmap, "title", false, false);
										filterFav = 0;
									}
									else {
										if (filterFav == 0) {
											filterFav = 1;
											length = songmap.size();
											r = length - 1;
											for(int _repeat70 = 0; _repeat70 < (int)(length); _repeat70++) {
												if (songmap.get((int)r).containsKey("favorite")) {
													value1 = songmap.get((int)r).get("favorite").toString();
													if (value1.equals("true")) {
														
													}
													else {
														songmap.remove((int)(r));
													}
												}
												else {
													songmap.remove((int)(r));
												}
												r--;
											}
											if (mp.isPlaying()) {
												_MediaPause();
											}
											mp.reset();
											mp.release();
											songPosition = -1;
											linear4play.setVisibility(View.GONE);
											if (expand == 0) {
												
											}
											else {
												listview1.setVisibility(View.VISIBLE);
												linear6.setVisibility(View.GONE);
												expand = 0;
											}
										}
									}
								}
							}
							if (songmap.size() == 0) {
								QueryUtil.showMessage(getApplicationContext(), "Empty list");
								if (!mp.isPlaying()) {
									linear4play.setVisibility(View.GONE);
								}
							}
							listview1.setAdapter(new Listview1Adapter(songmap));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						else {
							QueryUtil.showMessage(getApplicationContext(), "Empty list");
						}
					}
					else {
						QueryUtil.showMessage(getApplicationContext(), "Select an option");
					}
				} catch(Exception e){
					QueryUtil.showMessage(getApplicationContext(), "Action failed");
					i.setClass(getApplicationContext(), MainActivity.class);
					startActivity(i);
					finish();
				}
			}
		});
		d.create().show();
	}
	
	
	private void _Single_Choice_Dialog (final AlertDialog.Builder _dialog, final ArrayList<String> _list) {
		final CharSequence[] _items = _list.toArray(new String[_list.size()]);
		_dialog.setSingleChoiceItems(_items, -1, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				wh_ = which;
				item_ = _list.get((int)(wh_));
				
			}});
	}
	
	
	private void _move2 () {
		if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {

			QueryUtil.showMessage(getApplicationContext(), "Please allow storage permission");
		}else{

			songmap.clear();
			_getAllSong();
			allSongsJson = new Gson().toJson(songmap);
			_SortMap(songmap, "title", false, true);
			listview1.setAdapter(new Listview1Adapter(songmap));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	
	private void _volume () {
		vol = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (seeking == 0) {
							seekbar2.setVisibility(View.INVISIBLE);
							vol.cancel();
						}
						else {
							_volume();
						}
					}
				});
			}
		};
		_timer.schedule(vol, (int)(2000));
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.cust, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final LinearLayout linear4 = (LinearLayout) _v.findViewById(R.id.linear4);
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final ImageView imageview3 = (ImageView) _v.findViewById(R.id.imageview3);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			
			textview1.setText(songmap.get((int)_position).get("title").toString());
			textview2.setText(songmap.get((int)_position).get("artist").toString().concat(" - ".concat(songmap.get((int)_position).get("folder").toString())));
			textview2.setTextColor(0x99000000);
			imageview2.setVisibility(View.VISIBLE);
			textview1.setSingleLine(true);
			textview1.setEllipsize(TextUtils.TruncateAt.END);
			textview2.setSingleLine(true);
			textview2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
			if (songmap.get((int)_position).containsKey("favorite")) {
				if (songmap.get((int)_position).get("favorite").toString().equals("true")) {
					imageview2.setImageResource(R.drawable.ic_heart_fill);
				}
				else {
					imageview2.setImageResource(R.drawable.ic_heart_empty);
				}
			}
			else {
				imageview2.setImageResource(R.drawable.ic_heart_empty);
			}
			
			return _v;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
