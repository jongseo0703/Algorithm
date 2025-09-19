import java.io.*;
import java.util.*;

public class Main {
  static boolean[][] isVisited = new boolean[2001][2001];

  static int S;

  static class State {
    int screen, clip, time;

    State(int screen, int clip, int time) {
      this.screen = screen;
      this.clip = clip;
      this.time = time;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    S = Integer.parseInt(br.readLine());

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    Queue<State> queue = new LinkedList<>();
    queue.add(new State(1, 0, 0));

    isVisited[1][0] = true;

    while(!queue.isEmpty()) {
      State s = queue.poll();
      int curScreen = s.screen;
      int curClip = s.clip;
      int curTime = s.time;

      if(curScreen == S) {
        return curTime;
      }

      if(!isVisited[curScreen][curScreen]) {
        isVisited[curScreen][curScreen] = true;
        queue.add(new State(curScreen, curScreen, curTime + 1));
      }

      if(curClip > 0 && curScreen + curClip < 2001) {
        if(!isVisited[curScreen + curClip][curClip]) {
          isVisited[curScreen + curClip][curClip] = true;
          queue.add(new State(curScreen + curClip, curClip, curTime + 1));
        }
      }

      if(curScreen > 0) {
        if(!isVisited[curScreen - 1][curClip]) {
          isVisited[curScreen - 1][curClip] = true;
          queue.add(new State(curScreen - 1, curClip, curTime + 1));
        }
      }
    }
    return -1;
  }

}
